package com.bank.ledger.domain.model;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public class JournalEntry {
    private final UUID id;
    private final List<LedgerEntry> entries;
    private final Instant postedAt;

    public JournalEntry(List<LedgerEntry> entries) {
        this.id = UUID.randomUUID();
        this.entries = entries;
        this.postedAt = Instant.now();
    }

    public UUID getId() {
        return id;
    }

    public List<LedgerEntry> getEntries() {
        return entries;
    }

    public Instant getPostedAt() {
        return postedAt;
    }
}