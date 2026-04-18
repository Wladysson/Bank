package com.bank.payments.infrastructure.idempotency;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "idempotency_keys")
public class IdempotencyEntity {

    @Id
    private String key;

    private String requestHash;

    @Lob
    private String response;

    private LocalDateTime createdAt;

    public IdempotencyEntity() {}

    public IdempotencyEntity(String key, String requestHash, String response) {
        this.key = key;
        this.requestHash = requestHash;
        this.response = response;
        this.createdAt = LocalDateTime.now();
    }

    // getters e setters

    public String getKey() { return key; }
    public void setKey(String key) { this.key = key; }

    public String getRequestHash() { return requestHash; }
    public void setRequestHash(String requestHash) { this.requestHash = requestHash; }

    public String getResponse() { return response; }
    public void setResponse(String response) { this.response = response; }

    public LocalDateTime getCreatedAt() { return createdAt; }
}