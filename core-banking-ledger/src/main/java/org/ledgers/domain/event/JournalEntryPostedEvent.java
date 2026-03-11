package com.bank.ledger.domain.event;

import com.bank.ledger.domain.model.JournalEntry;
import java.time.Instant;
import java.util.UUID;

public class JournalEntryPostedEvent {
    private final UUID eventId;
    private final JournalEntry journalEntry;
    private final Instant occurredAt;

    public JournalEntryPostedEvent(JournalEntry journalEntry) {
        this.eventId = UUID.randomUUID();
        this.journalEntry = journalEntry;
        this.occurredAt = Instant.now();
    }

    public UUID getEventId() {
        return eventId;
    }

    public JournalEntry getJournalEntry() {
        return journalEntry;
    }

    public Instant getOccurredAt() {
        return occurredAt;
    }
}