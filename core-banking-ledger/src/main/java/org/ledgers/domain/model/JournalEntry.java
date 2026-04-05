package org.bank.ledger.domain.model;

import java.util.UUID;
import java.time.Instant;

public class JournalEntry {

    private final UUID id;
    private final UUID ledgerAccountId;
    private final long amount;
    private final Instant createdAt;

    public JournalEntry(UUID id, UUID ledgerAccountId, long amount, Instant createdAt) {
        this.id = id;
        this.ledgerAccountId = ledgerAccountId;
        this.amount = amount;
        this.createdAt = createdAt;
    }

    public UUID getId() {
        return id;
    }

    public UUID getLedgerAccountId() {
        return ledgerAccountId;
    }

    public long getAmount() {
        return amount;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}