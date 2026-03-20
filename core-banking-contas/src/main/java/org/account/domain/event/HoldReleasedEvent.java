package com.bank.account.domain.event;

import java.time.Instant;
import java.util.UUID;

public class HoldReleasedEvent {

    private final UUID eventId;
    private final UUID accountId;
    private final UUID holdId;
    private final Instant occurredAt;

    public HoldReleasedEvent(UUID accountId, UUID holdId) {
        this.eventId = UUID.randomUUID();
        this.accountId = accountId;
        this.holdId = holdId;
        this.occurredAt = Instant.now();
    }

    public UUID getEventId() { return eventId; }
    public UUID getAccountId() { return accountId; }
    public UUID getHoldId() { return holdId; }
    public Instant getOccurredAt() { return occurredAt; }
}