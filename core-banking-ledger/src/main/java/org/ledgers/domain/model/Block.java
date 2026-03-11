package com.bank.ledger.domain.model;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public class Block {
    private final UUID id;
    private final List<LedgerEntry> ledgerEntries;
    private final Instant sealedAt;

    public Block(List<LedgerEntry> ledgerEntries) {
        this.id = UUID.randomUUID();
        this.ledgerEntries = ledgerEntries;
        this.sealedAt = null; // Inicialmente não selado
    }

    public UUID getId() {
        return id;
    }

    public List<LedgerEntry> getLedgerEntries() {
        return ledgerEntries;
    }
}