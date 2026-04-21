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
    public Long getId() {
        return id;
    }

    public String getAggregateId() {
        return aggregateId;
    }

    public void setAggregateId(String aggregateId) {
        this.aggregateId = aggregateId;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}