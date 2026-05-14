package com.bank.transactions.domain.event.recurring;

import java.time.LocalDateTime;

// Evento responsável pela criação de pagamentos recorrentes
public class RecurringPaymentCreatedEvent {

    // Identificador da recorrência
    private final String recurringPaymentId;

    // Conta de origem
    private final String sourceAccountId;

    // Data de criação do evento
    private final LocalDateTime occurredAt;

    public RecurringPaymentCreatedEvent(
            String recurringPaymentId,
            String sourceAccountId
    ) {
        this.recurringPaymentId = recurringPaymentId;
        this.sourceAccountId = sourceAccountId;
        this.occurredAt = LocalDateTime.now();
    }

    public String getRecurringPaymentId() {
        return recurringPaymentId;
    }

    public String getSourceAccountId() {
        return sourceAccountId;
    }

    public LocalDateTime getOccurredAt() {
        return occurredAt;
    }
}