package com.bank.transactions.domain.event.pix;

import java.math.BigDecimal;
import java.time.LocalDateTime;

// Evento responsável pela criação de transações PIX
public class PixTransactionCreatedEvent {

    // Identificador da transação
    private final String transactionId;

    // Valor da transação
    private final BigDecimal amount;

    // Data de criação do evento
    private final LocalDateTime occurredAt;

    public PixTransactionCreatedEvent(
            String transactionId,
            BigDecimal amount
    ) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.occurredAt = LocalDateTime.now();
    }

    public String getTransactionId() {
        return transactionId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDateTime getOccurredAt() {
        return occurredAt;
    }
}