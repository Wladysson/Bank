package com.bank.transactions.domain.event.common;

import java.time.LocalDateTime;

// Evento responsável pela geração de comprovantes
public class ReceiptGeneratedEvent {

    // Identificador do comprovante
    private final String receiptId;

    // Identificador da transação
    private final String transactionId;

    // Data de geração
    private final LocalDateTime occurredAt;

    public ReceiptGeneratedEvent(
            String receiptId,
            String transactionId
    ) {
        this.receiptId = receiptId;
        this.transactionId = transactionId;
        this.occurredAt = LocalDateTime.now();
    }

    public String getReceiptId() {
        return receiptId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public LocalDateTime getOccurredAt() {
        return occurredAt;
    }
}