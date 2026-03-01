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

        // Cria comando contábil baseado no pagamento
        PostJournalCommand command = buildJournalCommand(paymentId);

        saga.start(state, command);
    }

    private PostJournalCommand buildJournalCommand(UUID paymentId) {
        // mapear dados do event
        // para contas contábeis corretas
        // Exemplo fictício (em produção vai vir do evento PaymentCreatedEvent)
        BigDecimal amount = BigDecimal.valueOf(100.00);

        UUID debitAccountId = UUID.fromString("11111111-1111-1111-1111-111111111111");
        UUID creditAccountId = UUID.fromString("22222222-2222-2222-2222-222222222222");

        JournalEntryLine debitLine = new JournalEntryLine(
                debitAccountId,
                amount,
                EntryType.DEBIT
        );

        JournalEntryLine creditLine = new JournalEntryLine(
                creditAccountId,
                amount,
                EntryType.CREDIT
        );

        return new PostJournalCommand(
                UUID.randomUUID(),
                LocalDateTime.now(), //journal
                "Payment posting for " + paymentId,
                java.util.List.of()
        );
    }

    private PostJournalCommand buildReversalCommand(PaymentLedgerSagaState state) {

        BigDecimal amount = state.getAmount();

        UUID debitAccountId = state.getOriginalCreditAccount();
        UUID creditAccountId = state.getOriginalDebitAccount();

        JournalEntryLine debitLine = new JournalEntryLine(
                debitAccountId,
                amount,
                EntryType.DEBIT
        );

        JournalEntryLine creditLine = new JournalEntryLine(
                creditAccountId,
                amount,
                EntryType.CREDIT
        );

        return new PostJournalCommand(
                UUID.randomUUID(),
                LocalDateTime.now(),
                "Reverso do pagamento" + state.getPaymentId(),
                List.of(debitLine, creditLine)
        );
    }
}