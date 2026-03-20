package com.bank.account.domain.event;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public class LimitUpdatedEvent {

    private final UUID eventId;
    private final UUID accountId;

    private final BigDecimal dailyTransferLimit;
    private final BigDecimal dailyWithdrawLimit;
    private final BigDecimal monthlyTransferLimit;

    private final Instant occurredAt;

    public LimitUpdatedEvent(
            UUID accountId,
            BigDecimal dailyTransferLimit,
            BigDecimal dailyWithdrawLimit,
            BigDecimal monthlyTransferLimit
    ) {
        this.eventId = UUID.randomUUID();
        this.accountId = accountId;
        this.dailyTransferLimit = dailyTransferLimit;
        this.dailyWithdrawLimit = dailyWithdrawLimit;
        this.monthlyTransferLimit = monthlyTransferLimit;
        this.occurredAt = Instant.now();
    }

    public UUID getEventId() { return eventId; }
    public UUID getAccountId() { return accountId; }

    public BigDecimal getDailyTransferLimit() { return dailyTransferLimit; }
    public BigDecimal getDailyWithdrawLimit() { return dailyWithdrawLimit; }
    public BigDecimal getMonthlyTransferLimit() { return monthlyTransferLimit; }

    public Instant getOccurredAt() { return occurredAt; }
}

