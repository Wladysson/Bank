package com.bank.ledger.domain.model;

import java.util.UUID;
import java.time.Instant;

public class LedgerEntry {

    private final UUID id;
    private final UUID accountId;
    private final long amount;
    private final EntryType type;
    private final Instant timestamp;

    public LedgerEntry(UUID id, UUID accountId, long amount, EntryType type, Instant timestamp) {
        this.id = id;
        this.accountId = accountId;
        this.amount = amount;
        this.type = type;
        this.timestamp = timestamp;
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

    public Instant getTimestamp() {
        return timestamp;
    }
}