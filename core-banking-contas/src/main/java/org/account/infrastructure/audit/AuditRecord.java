package com.bank.account.infrastructure.audit;

import java.time.Instant;
import java.util.Map;
import java.util.UUID;

public class AuditRecord {

    private final String id;
    private final String accountId;
    private final String eventType;
    private final Map<String, Object> details;
    private final String actorId;
    private final String correlationId;
    private final Instant timestamp;

    public AuditRecord(
            String accountId,
            String eventType,
            Map<String, Object> details,
            String actorId,
            String correlationId,
            Instant timestamp
    ) {
        this.id = UUID.randomUUID().toString(); // gera id único para o registro
        this.accountId = accountId; // identifica a conta auditada
        this.eventType = eventType; // tipo de evento auditado
        this.details = details; // detalhes específicos da operação
        this.actorId = actorId; // usuário/sistema que executou a ação
        this.correlationId = correlationId; // rastreia operações relacionadas
        this.timestamp = timestamp; // quando ocorreu a ação
    }

    public String getId() {
        return id;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getEventType() {
        return eventType;
    }

    public Map<String, Object> getDetails() {
        return details;
    }

    public String getActorId() {
        return actorId;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public Instant getTimestamp() {
        return timestamp;
    }
}
