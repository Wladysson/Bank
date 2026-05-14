package com.bank.transactions.domain.event.common;

import java.time.LocalDateTime;

// Evento responsável pela conclusão de transações
public class TransactionCompletedEvent {

    // Identificador da transação
    private final String transactionId;

    // Código autenticador da operação
    private final String authenticationCode;

    // Data de conclusão
    private final LocalDateTime occurredAt;

    public TransactionCompletedEvent(
            String transactionId,
            String authenticationCode
    ) {
        this.transactionId = transactionId;
        this.authenticationCode = authenticationCode;
        this.occurredAt = LocalDateTime.now();
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getAuthenticationCode() {
        return authenticationCode;
    }

    public LocalDateTime getOccurredAt() {
        return occurredAt;
    }
}