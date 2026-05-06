package com.bank.transactions.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

public class PixTransaction {

    private final UUID id;
    private final String accountId;
    private final PixKey pixKey;
    private final BigDecimal amount;
    private final String description;
    private final PixTransactionType type;

    private String endToEndId;
    private PixTransactionStatus status;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
    private OffsetDateTime completedAt;

    public PixTransaction(String accountId,
                          PixKey pixKey,
                          BigDecimal amount,
                          String description,
                          PixTransactionType type) {

        this.id = UUID.randomUUID();
        this.accountId = Objects.requireNonNull(accountId);
        this.pixKey = Objects.requireNonNull(pixKey);
        this.amount = Objects.requireNonNull(amount);
        this.description = description;
        this.type = Objects.requireNonNull(type);

        this.status = PixTransactionStatus.CREATED;
        this.createdAt = OffsetDateTime.now();
        this.updatedAt = this.createdAt;
    }

    // Estado

    public void markAsProcessing() {
        ensureStatus(PixTransactionStatus.CREATED);
        this.status = PixTransactionStatus.PROCESSING;
        touch();
    }

    public void markAsCompleted(String endToEndId) {
        ensureStatus(PixTransactionStatus.PROCESSING);
        this.status = PixTransactionStatus.COMPLETED;
        this.endToEndId = endToEndId;
        this.completedAt = OffsetDateTime.now();
        touch();
    }

    public void markAsFailed() {
        ensureNotFinalState();
        this.status = PixTransactionStatus.FAILED;
        touch();
    }

    // ❗ Refund NÃO altera essa transação
    // é outra transação (isso é MUITO importante)

    public static PixTransaction refundOf(PixTransaction original, String reason) {
        return new PixTransaction(
                original.accountId,
                original.pixKey,
                original.amount,
                reason,
                PixTransactionType.REFUND
        );
    }

    // 🔒 Regras

    private void ensureStatus(PixTransactionStatus expected) {
        if (this.status != expected) {
            throw new IllegalStateException(
                    "Estado inválido. Esperado: " + expected + " atual: " + status
            );
        }
    }

    private void ensureNotFinalState() {
        if (this.status == PixTransactionStatus.COMPLETED ||
                this.status == PixTransactionStatus.FAILED) {
            throw new IllegalStateException("Transação já finalizada");
        }
    }

    private void touch() {
        this.updatedAt = OffsetDateTime.now();
    }

    // 📊 Queries

    public boolean isProcessing() {
        return this.status == PixTransactionStatus.PROCESSING;
    }

    public boolean isCompleted() {
        return this.status == PixTransactionStatus.COMPLETED;
    }

    // 📦 Getters

    public UUID getId() { return id; }
    public String getAccountId() { return accountId; }
    public PixKey getPixKey() { return pixKey; }
    public BigDecimal getAmount() { return amount; }
    public String getDescription() { return description; }
    public PixTransactionType getType() { return type; }
    public String getEndToEndId() { return endToEndId; }
    public PixTransactionStatus getStatus() { return status; }
    public OffsetDateTime getCreatedAt() { return createdAt; }
    public OffsetDateTime getUpdatedAt() { return updatedAt; }
    public OffsetDateTime getCompletedAt() { return completedAt; }

    // Identidade

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PixTransaction that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}