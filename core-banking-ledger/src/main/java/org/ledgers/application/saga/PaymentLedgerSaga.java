package com.bank.ledger.application.saga;

import java.util.List;
import com.bank.ledger.application.command.PostJournalCommand;
import com.bank.ledger.application.service.JournalPostingService;
import com.bank.ledger.domain.event.DomainEventPublisher;
import com.bank.ledger.domain.model.LedgerEntry;
import com.bank.ledger.domain.model.EntryType;
import com.bank.ledger.domain.event.PaymentPostingFailedEvent;

import java.util.UUID;

public class PaymentLedgerSaga {

    private final JournalPostingService journalPostingService;
    private final DomainEventPublisher eventPublisher;

    public PaymentLedgerSaga(JournalPostingService journalPostingService,
                             DomainEventPublisher eventPublisher) {
        this.journalPostingService = journalPostingService;
        this.eventPublisher = eventPublisher;
    }

    public void start(PaymentLedgerSagaState state, PostJournalCommand command) {

        try {
            journalPostingService.post(command);

            state.markJournalPosted();
            state.markCompleted();

        } catch (Exception ex) {
            compensate(state);
        }
    }

    private void compensate(PaymentLedgerSagaState state) {

        if (state.isCompensated()) {
            return;
        }

        try {
            PostJournalCommand reversalCommand = buildReversalCommand(state);

            journalPostingService.post(reversalCommand);

            PaymentPostingFailedEvent failedEvent =
                    new PaymentPostingFailedEvent(
                            state.getPaymentId(),
                            "Ledger posting failed. Compensation executed."
                    );

            eventPublisher.publish(failedEvent);

            state.markCompensated();

        } catch (Exception ex) {

            state.markFailed();

            throw new IllegalStateException("Falha na compensação", ex);
        }
    }

    private PostJournalCommand buildReversalCommand(PaymentLedgerSagaState state) {

        var reversedEntries = state.getEntries().stream()
                .map(entry -> new PostJournalCommand.EntryCommand(
                        entry.getAccountId().toString(),
                        java.math.BigDecimal.valueOf(entry.getAmount()),
                        entry.getType().reverse() == EntryType.DEBIT
                ))
                .toList();

        return new PostJournalCommand(
                state.getPaymentId(),
                java.time.LocalDateTime.now(),
                "REVERSAL",
                reversedEntries
        );
    }

    private EntryType reverseType(EntryType type) {
        return type == EntryType.DEBIT
                ? EntryType.CREDIT
                : EntryType.DEBIT;
    }
}