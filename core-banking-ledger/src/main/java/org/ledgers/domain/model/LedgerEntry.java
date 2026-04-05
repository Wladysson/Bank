package com.bank.ledger.domain.model;

import java.util.UUID;
import java.time.Instant;

public class LedgerEntry {

    private final UUID id;
    private final UUID accountId;
    private final long amount;
    private final Instant createdAt;

    public LedgerEntry(UUID id, UUID accountId, long amount, Instant createdAt) {
        this.id = id;
        this.accountId = accountId;
        this.amount = amount;
        this.createdAt = createdAt;
    }

    public UUID getId() {
        return id;
    }

    public UUID getAccountId() {
        return accountId;
    }

    public long getAmount() {
        return amount;
    }

    public EntryType getType() {
        return type;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}