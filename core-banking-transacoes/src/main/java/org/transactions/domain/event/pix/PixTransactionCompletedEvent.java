package com.bank.transactions.domain.event.pix;

import java.time.LocalDateTime;

// Evento responsável pela conclusão da transação PIX
public class PixTransactionCompletedEvent {

    // Identificador da transação
    private final String transactionId;

    // Código de autenticação da operação
    private final String authenticationCode;

    // Momento da conclusão
    private final LocalDateTime occurredAt;

    public PixTransactionCompletedEvent(
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