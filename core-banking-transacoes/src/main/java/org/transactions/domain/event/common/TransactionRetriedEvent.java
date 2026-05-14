package com.bank.transactions.domain.event.common;

import java.time.LocalDateTime;

// Evento responsável pelo reprocessamento de transações
public class TransactionRetriedEvent {

    // Identificador da transação
    private final String transactionId;

    // Número da tentativa atual
    private final Integer retryCount;

    // Momento da retentativa
    private final LocalDateTime occurredAt;

    public TransactionRetriedEvent(
            String transactionId,
            Integer retryCount
    ) {
        this.transactionId = transactionId;
        this.retryCount = retryCount;
        this.occurredAt = LocalDateTime.now();
    }

    public String getTransactionId() {
        return transactionId;
    }

    public Integer getRetryCount() {
        return retryCount;
    }

    public LocalDateTime getOccurredAt() {
        return occurredAt;
    }
}