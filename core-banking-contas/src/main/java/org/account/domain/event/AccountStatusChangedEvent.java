package com.bank.account.domain.event;

import java.time.Instant;
import java.util.UUID;

public class AccountStatusChangedEvent {

    private final UUID eventId;
    private final UUID accountId;
    private final String status;
    private final Instant occurredAt;

    public AccountStatusChangedEvent(UUID accountId, String status) {
        this.eventId = UUID.randomUUID();
        this.accountId = accountId;
        this.status = status;
        this.occurredAt = Instant.now();
    }

    public UUID getEventId() { return eventId; }
    public UUID getAccountId() { return accountId; }
    public String getStatus() { return status; }
    public Instant getOccurredAt() { return occurredAt; }
}
