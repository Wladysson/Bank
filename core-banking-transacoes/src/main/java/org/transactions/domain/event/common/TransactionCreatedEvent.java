package com.bank.transactions.domain.event.common;

import java.time.LocalDateTime;

// Evento responsável pela criação de transações
public class TransactionCreatedEvent {

    // Identificador da transação
    private final String transactionId;

    // Tipo da transação
    private final String transactionType;

    // Momento da criação
    private final LocalDateTime occurredAt;

    public TransactionCreatedEvent(
            String transactionId,
            String transactionType
    ) {
        this.transactionId = transactionId;
        this.transactionType = transactionType;
        this.occurredAt = LocalDateTime.now();
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public LocalDateTime getOccurredAt() {
        return occurredAt;
    }
}