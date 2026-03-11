package com.bank.ledger.domain.event;

import com.bank.ledger.domain.model.LedgerEntry;
import java.time.Instant;
import java.util.UUID;

public class LedgerEntryCreatedEvent {
    private final UUID eventId;
    private final LedgerEntry ledgerEntry;
    private final Instant occurredAt;

    public LedgerEntryCreatedEvent(LedgerEntry ledgerEntry) {
        this.eventId = UUID.randomUUID();
        this.ledgerEntry = ledgerEntry;
        this.occurredAt = Instant.now();
    }

    public UUID getEventId() {
        return eventId;
    }

    public LedgerEntry getLedgerEntry() {
        return ledgerEntry;
    }

    public Instant getOccurredAt() {
        return occurredAt;
    }
}