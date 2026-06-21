package com.bank.account.hold.domain.event;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class HoldExpiredEvent {

    private final String holdId; // identificador da reserva expirada

    private final String accountId; // conta associada à reserva

    private final BigDecimal amount; // valor que estava reservado

    private final LocalDateTime expirationDate; // data em que a reserva expirou

    private final LocalDateTime occurredAt; // momento em que o evento foi gerado

    public HoldExpiredEvent(
            String holdId,
            String accountId,
            BigDecimal amount,
            LocalDateTime expirationDate
    ) {
        this.holdId = holdId;
        this.accountId = accountId;
        this.amount = amount;
        this.expirationDate = expirationDate;
        this.occurredAt = LocalDateTime.now();
    }

    public String getHoldId() {
        return holdId;
    }

    public String getAccountId() {
        return accountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public LocalDateTime getOccurredAt() {
        return occurredAt;
    }
}