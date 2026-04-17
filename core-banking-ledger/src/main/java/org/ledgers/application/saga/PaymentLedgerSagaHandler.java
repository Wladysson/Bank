package com.bank.ledger.application.saga;

import com.bank.ledger.application.command.PostJournalCommand;
import com.bank.ledger.domain.model.LedgerEntry;
import com.bank.ledger.domain.model.JournalEntryLine;
import com.bank.ledger.domain.model.EntryType;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.time.LocalDateTime;
import java.util.UUID;
import java.math.BigDecimal;

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
        BigDecimal amount = BigDecimal.valueOf(100.00);// valor do pagamento, por exemplo
        List<LedgerEntry> entries = Collections.emptyList();

        UUID originalDebitAccount = UUID.fromString("11111111-1111-1111-1111-111111111111");
        UUID originalCreditAccount = UUID.fromString("22222222-2222-2222-2222-222222222222");

        PaymentLedgerSagaState state =
                new PaymentLedgerSagaState(paymentId, amount, entries, originalDebitAccount, originalCreditAccount); //passa os parametros para o paymentledgersagastate

        // Cria comando contábil baseado no pagamento
        PostJournalCommand command = buildJournalCommand(paymentId);

        saga.start(state, command);
    }

    private PostJournalCommand buildJournalCommand(UUID paymentId) {
        // mapear dados do event para registro
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

        BigDecimal amount = state.getAmount(); //state  da variavel correta do tratamento que vai fazer reverso
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

        List<PostJournalCommand.EntryCommand> entries = List.of(
                new PostJournalCommand.EntryCommand(
                        debitLine.getAccountId().toString(),
                        debitLine.getAmount(),
                        true // true indica débito
                ),
                new PostJournalCommand.EntryCommand(
                        creditLine.getAccountId().toString(),
                        creditLine.getAmount(),
                        false // false indica crédito
                )
        );

        return new PostJournalCommand(
                UUID.randomUUID(),
                LocalDateTime.now(),
                "Reverso do pagamento " + state.getPaymentId(),
                entries  // <-- usar a lista correta de EntryCommand
        );
    }
}