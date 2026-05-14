package com.bank.transactions.domain.event.recurring;

import java.time.LocalDateTime;

// Evento responsável pela execução de pagamentos recorrentes
public class RecurringPaymentExecutedEvent {

    // Identificador da recorrência
    private final String recurringPaymentId;

    // Identificador da transação gerada
    private final String transactionId;

    // Momento da execução
    private final LocalDateTime occurredAt;

    public RecurringPaymentExecutedEvent(
            String recurringPaymentId,
            String transactionId
    ) {
        this.recurringPaymentId = recurringPaymentId;
        this.transactionId = transactionId;
        this.occurredAt = LocalDateTime.now();
    }

    public String getRecurringPaymentId() {
        return recurringPaymentId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public LocalDateTime getOccurredAt() {
        return occurredAt;
    }
}