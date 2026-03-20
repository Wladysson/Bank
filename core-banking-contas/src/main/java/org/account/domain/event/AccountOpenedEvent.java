package com.bank.account.domain.event;

import java.time.Instant;
import java.util.UUID;

public class AccountOpenedEvent {

    private final UUID eventId;
    private final UUID accountId;
    private final String accountNumber;
    private final String accountType;
    private final Instant occurredAt;

    public AccountOpenedEvent(UUID accountId, String accountNumber, String accountType) {
        this.eventId = UUID.randomUUID();
        this.accountId = accountId;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.occurredAt = Instant.now();
    }

    public UUID getEventId() { return eventId; }
    public UUID getAccountId() { return accountId; }
    public String getAccountNumber() { return accountNumber; }
    public String getAccountType() { return accountType; }
    public Instant getOccurredAt() { return occurredAt; }
}