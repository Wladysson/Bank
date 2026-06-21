package com.bank.account.hold.domain.event;

import com.bank.account.hold.domain.model.HoldReason;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class HoldCreatedEvent {

    private final String holdId; // identificador da reserva

    private final String accountId; // conta que recebeu a reserva

    private final BigDecimal amount; // valor reservado

    private final HoldReason reason; // motivo da reserva

    private final LocalDateTime expirationDate; // data de expiração da reserva

    private final LocalDateTime occurredAt; // momento do evento

    public HoldCreatedEvent(
            String holdId,
            String accountId,
            BigDecimal amount,
            HoldReason reason,
            LocalDateTime expirationDate
    ) {
        this.holdId = holdId;
        this.accountId = accountId;
        this.amount = amount;
        this.reason = reason;
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

    public HoldReason getReason() {
        return reason;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public LocalDateTime getOccurredAt() {
        return occurredAt;
    }
}