package com.bank.transactions.domain.event.pix;

import java.time.LocalDateTime;

// Evento responsável pelo estorno de transações PIX
public class PixTransactionRefundedEvent {

    // Identificador da transação original
    private final String originalTransactionId;

    // Identificador da devolução
    private final String refundTransactionId;

    // Momento do estorno
    private final LocalDateTime occurredAt;

    public PixTransactionRefundedEvent(
            String originalTransactionId,
            String refundTransactionId
    ) {
        this.originalTransactionId = originalTransactionId;
        this.refundTransactionId = refundTransactionId;
        this.occurredAt = LocalDateTime.now();
    }

    public String getOriginalTransactionId() {
        return originalTransactionId;
    }

    public String getRefundTransactionId() {
        return refundTransactionId;
    }

    public LocalDateTime getOccurredAt() {
        return occurredAt;
    }
}