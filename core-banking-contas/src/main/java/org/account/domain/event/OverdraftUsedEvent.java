package com.bank.account.domain.event;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public class OverdraftUsedEvent {

    private final UUID eventId;
    private final UUID accountId;
    private final BigDecimal amountUsed;
    private final BigDecimal totalUsed;
    private final Instant occurredAt;

    public OverdraftUsedEvent(UUID accountId, BigDecimal amountUsed, BigDecimal totalUsed) {
        this.eventId = UUID.randomUUID();
        this.accountId = accountId;
        this.amountUsed = amountUsed;
        this.totalUsed = totalUsed;
        this.occurredAt = Instant.now();
    }

    public UUID getEventId() { return eventId; }
    public UUID getAccountId() { return accountId; }
    public BigDecimal getAmountUsed() { return amountUsed; }
    public BigDecimal getTotalUsed() { return totalUsed; }
    public Instant getOccurredAt() { return occurredAt; }
}