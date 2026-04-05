package com.bank.ledger.application.saga;

import com.bank.ledger.application.command.PostJournalCommand;
import com.bank.ledger.application.service.JournalPostingService;
import com.bank.ledger.domain.event.DomainEventPublisher;

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
            UUID journalId = journalPostingService.post(command);

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
}