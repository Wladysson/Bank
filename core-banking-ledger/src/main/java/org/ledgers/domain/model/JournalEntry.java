package com.bank.ledger.domain.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class JournalEntry {

    private final UUID id;
    private final LocalDateTime transactionDate;
    private final String description;
    private final List<LedgerEntry> entries;

    public JournalEntry(
            UUID id,
            LocalDateTime transactionDate,
            String description,
            List<LedgerEntry> entries
    ) {
        this.id = id;
        this.transactionDate = transactionDate;
        this.description = description;
        this.entries = entries;
    }

    public UUID getId() {
        return id;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public String getDescription() {
        return description;
    }

    public List<LedgerEntry> getEntries() {
        return entries;
    }
}