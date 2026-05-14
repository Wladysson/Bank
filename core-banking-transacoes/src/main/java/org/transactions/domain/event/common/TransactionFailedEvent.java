package com.bank.transactions.domain.event.common;

import java.time.LocalDateTime;

// Evento responsável por falhas transacionais
public class TransactionFailedEvent {

    // Identificador da transação
    private final String transactionId;

    // Motivo da falha
    private final String reason;

    // Momento da falha
    private final LocalDateTime occurredAt;

    public TransactionFailedEvent(
            String transactionId,
            String reason
    ) {
        this.transactionId = transactionId;
        this.reason = reason;
        this.occurredAt = LocalDateTime.now();
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getReason() {
        return reason;
    }

    public LocalDateTime getOccurredAt() {
        return occurredAt;
    }
}