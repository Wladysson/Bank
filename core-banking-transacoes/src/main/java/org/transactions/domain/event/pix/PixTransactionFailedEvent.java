package com.bank.transactions.domain.event.pix;

import java.time.LocalDateTime;

// Evento responsável por falhas em transações PIX
public class PixTransactionFailedEvent {

    // Identificador da transação
    private final String transactionId;

    // Motivo da falha
    private final String failureReason;

    // Data do evento
    private final LocalDateTime occurredAt;

    public PixTransactionFailedEvent(
            String transactionId,
            String failureReason
    ) {
        this.transactionId = transactionId;
        this.failureReason = failureReason;
        this.occurredAt = LocalDateTime.now();
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public LocalDateTime getOccurredAt() {
        return occurredAt;
    }
}