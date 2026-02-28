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
            // Etapa 1: Postar no Ledger
            UUID journalId = journalPostingService.post(command);

            state.markJournalPosted();

            // Etapa 2: Finalizar Saga
            state.markCompleted();

        } catch (Exception ex) {
            // Se falhar → compensação
            compensate(state);
        }
    }

    private void compensate(PaymentLedgerSagaState state) {

        // - Publicar evento PaymentFailed
        // - Criar lançamento reverso
        // - Notificar outro serviço

        state.markFailed();
    }
}