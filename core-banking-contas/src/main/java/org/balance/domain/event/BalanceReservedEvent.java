package com.bank.account.domain.event;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public class BalanceReservedEvent {

    private final UUID eventId;
    private final UUID accountId;
    private final UUID holdId;
    private final BigDecimal amount;
    private final Instant occurredAt;

    public BalanceReservedEvent(UUID accountId, UUID holdId, BigDecimal amount) {
        this.eventId = UUID.randomUUID();
        this.accountId = accountId;
        this.holdId = holdId;
        this.amount = amount;
        this.occurredAt = Instant.now();
    }

    public UUID getEventId() { return eventId; }
    public UUID getAccountId() { return accountId; }
    public UUID getHoldId() { return holdId; }
    public BigDecimal getAmount() { return amount; }
    public Instant getOccurredAt() { return occurredAt; }
}