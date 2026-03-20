package com.bank.account.domain.event;

import java.time.Instant;
import java.util.UUID;

public class AccountCreatedEvent {

    private final UUID eventId;
    private final UUID accountId;
    private final String accountNumber;
    private final String accountType;
    private final UUID primaryHolderId;
    private final Instant occurredAt;

    public AccountCreatedEvent(UUID accountId, String accountNumber, String accountType, UUID primaryHolderId) {
        this.eventId = UUID.randomUUID();
        this.accountId = accountId;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.primaryHolderId = primaryHolderId;
        this.occurredAt = Instant.now();
    }

    public UUID getEventId() { return eventId; }
    public UUID getAccountId() { return accountId; }
    public String getAccountNumber() { return accountNumber; }
    public String getAccountType() { return accountType; }
    public UUID getPrimaryHolderId() { return primaryHolderId; }
    public Instant getOccurredAt() { return occurredAt; }
}

