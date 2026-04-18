package com.bank.payments.domain.event;

import java.math.BigDecimal;

public class CashbackGrantedEvent extends PaymentEvent {

    private final BigDecimal amount;

    public CashbackGrantedEvent(String paymentId, BigDecimal amount) {
        super(paymentId);
        this.amount = amount;
    }

    public BigDecimal getAmount() { return amount; }
}