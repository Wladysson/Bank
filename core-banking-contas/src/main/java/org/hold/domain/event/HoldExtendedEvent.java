package com.bank.account.hold.domain.event;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class HoldExtendedEvent {

    private final String holdId; // identificador da reserva

    private final String accountId; // conta associada ao hold

    private final LocalDateTime previousExpirationDate; // expiração anterior

    private final LocalDateTime newExpirationDate; // nova expiração após extensão

    private final BigDecimal amount; // valor mantido em reserva

    private final LocalDateTime occurredAt; // momento do evento

    public HoldExtendedEvent(
            String holdId,
            String accountId,
            LocalDateTime previousExpirationDate,
            LocalDateTime newExpirationDate,
            BigDecimal amount
    ) {
        this.holdId = holdId;
        this.accountId = accountId;
        this.previousExpirationDate = previousExpirationDate;
        this.newExpirationDate = newExpirationDate;
        this.amount = amount;
        this.occurredAt = LocalDateTime.now();
    }

    public String getHoldId() {
        return holdId;
    }

    public String getAccountId() {
        return accountId;
    }

    public LocalDateTime getPreviousExpirationDate() {
        return previousExpirationDate;
    }

    public LocalDateTime getNewExpirationDate() {
        return newExpirationDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDateTime getOccurredAt() {
        return occurredAt;
    }
}