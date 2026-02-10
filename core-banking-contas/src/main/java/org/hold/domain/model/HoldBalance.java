package com.bank.account.domain.model;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public class HoldBalance {

    private final UUID holdId;
    private final BigDecimal amount;
    private final Instant createdAt;
    private Instant releasedAt;
    private boolean active;

    public HoldBalance(BigDecimal amount) {
        this.holdId = UUID.randomUUID();
        this.amount = amount;
        this.createdAt = Instant.now();
        this.active = true;
    }

    public void release() {
        if (!active) {
            throw new IllegalStateException("Hold já liberado");
        }
        this.active = false;
        this.releasedAt = Instant.now();
    }

    public UUID getHoldId() { return holdId; }
    public BigDecimal getAmount() { return amount; }
    public boolean isActive() { return active; }
}