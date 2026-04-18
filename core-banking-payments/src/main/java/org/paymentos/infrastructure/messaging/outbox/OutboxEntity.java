package com.bank.payments.infrastructure.messaging.outbox;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "outbox")
public class OutboxEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String aggregateId;
    private String eventType;

    @Lob
    private String payload;

    private boolean processed;

    private LocalDateTime createdAt;

    public OutboxEntity() {}

    public OutboxEntity(String aggregateId, String eventType, String payload) {
        this.aggregateId = aggregateId;
        this.eventType = eventType;
        this.payload = payload;
        this.processed = false;
        this.createdAt = LocalDateTime.now();
    }

    // getters e setters
}