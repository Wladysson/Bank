package com.bank.account.infrastructure.audit;

import java.time.Instant;
import java.util.UUID;

public class AuditContext {

    private final String correlationId;
    private final String actorId;
    private final String actorType;
    private final Instant timestamp;

    public AuditContext(
            String correlationId,
            String actorId,
            String actorType,
            Instant timestamp
    ) {
        this.correlationId = correlationId; // identifica a correlação da operação
        this.actorId = actorId; // identifica usuário ou sistema executor
        this.actorType = actorType; // define origem da operação
        this.timestamp = timestamp; // registra momento da execução
    }

    public static AuditContext system() {

        return new AuditContext(
                UUID.randomUUID().toString(), // gera correlação automática
                "SYSTEM", // executor interno
                "SYSTEM",
                Instant.now()
        );
    }

    public String getCorrelationId() {
        return correlationId; // retorna id de correlação
    }

    public String getActorId() {
        return actorId; // retorna executor da operação
    }

    public String getActorType() {
        return actorType; // retorna tipo do executor
    }

    public Instant getTimestamp() {
        return timestamp; // retorna data da operação
    }
}