package com.bank.ledger.application.saga;

import com.bank.ledger.application.command.PostJournalCommand;

import java.time.LocalDateTime;
import java.util.UUID;

public class PaymentLedgerSagaHandler {

    private final PaymentLedgerSaga saga;

    public PaymentLedgerSagaHandler(PaymentLedgerSaga saga) {
        this.saga = saga;
    }

    // Simulando consumo de evento PaymentCreated
    public void handlePaymentCreated(UUID paymentId) {

        UUID sagaId = UUID.randomUUID();

        PaymentLedgerSagaState state =
                new PaymentLedgerSagaState(sagaId, paymentId);

        // Criar comando contábil baseado no pagamento
        PostJournalCommand command = buildJournalCommand(paymentId);

        saga.start(state, command);
    }

    private PostJournalCommand buildJournalCommand(UUID paymentId) {

        // mapear dados do evento
        // para contas contábeis corretas

        return new PostJournalCommand(
                UUID.randomUUID(),
                LocalDateTime.now(),
                "Payment posting for " + paymentId,
                java.util.List.of()
        );
    }
}