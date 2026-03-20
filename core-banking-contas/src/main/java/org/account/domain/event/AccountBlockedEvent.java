package com.bank.account.domain.event;

import java.time.Instant;
import java.util.UUID;

public class AccountBlockedEvent {

    private final UUID eventId;
    private final UUID accountId;
    private final String reason;
    private final Instant occurredAt;

    public AccountBlockedEvent(UUID accountId, String reason) {
        this.eventId = UUID.randomUUID();
        this.accountId = accountId;
        this.reason = reason;
        this.occurredAt = Instant.now();
    }

    public UUID getEventId() { return eventId; }
    public UUID getAccountId() { return accountId; }
    public String getReason() { return reason; }
    public Instant getOccurredAt() { return occurredAt; }
}