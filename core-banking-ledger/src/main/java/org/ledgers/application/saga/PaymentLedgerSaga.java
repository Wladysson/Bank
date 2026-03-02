package com.bank.ledger.application.saga;

import com.bank.ledger.application.command.PostJournalCommand;
import com.bank.ledger.application.service.JournalPostingService;

import java.util.UUID;

public class PaymentLedgerSaga {

    private final JournalPostingService journalPostingService;

    public PaymentLedgerSaga(JournalPostingService journalPostingService) {
        this.journalPostingService = journalPostingService;
    }

    public void start(PaymentLedgerSagaState state, PostJournalCommand command) {

        try {
            //Postar no Ledger
            UUID journalId = journalPostingService.post(command);

            state.markJournalPosted();
            // Finalizar Saga
            state.markCompleted();

        } catch (Exception ex) {
            // Se falhar vai na compensação
            compensate(state);
        }
    }

    private final JournalPostingService journalPostingService;
    private final DomainEventPublisher eventPublisher;

    private void compensate(PaymentLedgerSagaState state) {

        if (state.isCompensated()) {
            return;
        }

        try {
            // 1️criar lançamento reverso (estorno)
            PostJournalCommand reversalCommand = buildReversalCommand(state);

            journalPostingService.post(reversalCommand);

            // 2 publica evento de falha
            PaymentPostingFailedEvent failedEvent =
                    new PaymentPostingFailedEvent(
                            state.getPaymentId(),
                            "Ledger posting failed. Compensation executed."
                    );

            eventPublisher.publish(failedEvent);

            state.markCompensated();

        } catch (Exception ex) {

            // Aqui você pode enviar para Dead Letter,
            // ou logar para intervenção manual
            state.markFailed();

            throw new IllegalStateException("Falha na compensaçao", ex);
        }
    }
}