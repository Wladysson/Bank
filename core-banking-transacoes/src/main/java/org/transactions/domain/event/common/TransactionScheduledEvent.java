package com.bank.transactions.domain.event.common;

import java.time.LocalDateTime;

// Evento responsável pelo agendamento de transações
public class TransactionScheduledEvent {

    // Identificador do agendamento
    private final String scheduledTransactionId;

    // Data programada para execução
    private final LocalDateTime scheduledAt;

    // Momento do evento
    private final LocalDateTime occurredAt;

    public TransactionScheduledEvent(
            String scheduledTransactionId,
            LocalDateTime scheduledAt
    ) {
        this.scheduledTransactionId = scheduledTransactionId;
        this.scheduledAt = scheduledAt;
        this.occurredAt = LocalDateTime.now();
    }

    public String getScheduledTransactionId() {
        return scheduledTransactionId;
    }

    public LocalDateTime getScheduledAt() {
        return scheduledAt;
    }

    public LocalDateTime getOccurredAt() {
        return occurredAt;
    }
}