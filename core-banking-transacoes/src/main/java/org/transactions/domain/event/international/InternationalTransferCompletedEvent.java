package com.bank.transactions.domain.event.international;

import java.time.LocalDateTime;

// Evento responsável pela conclusão de transferências internacionais
public class InternationalTransferCompletedEvent {

    // Identificador da transferência
    private final String transactionId;

    // País de destino
    private final String destinationCountry;

    // Data da liquidação
    private final LocalDateTime occurredAt;

    public InternationalTransferCompletedEvent(
            String transactionId,
            String destinationCountry
    ) {
        this.transactionId = transactionId;
        this.destinationCountry = destinationCountry;
        this.occurredAt = LocalDateTime.now();
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getDestinationCountry() {
        return destinationCountry;
    }

    public LocalDateTime getOccurredAt() {
        return occurredAt;
    }
}