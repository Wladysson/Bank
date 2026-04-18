package com.bank.payments.domain.event;

import java.math.BigDecimal;

public class PaymentRefundedEvent extends PaymentEvent {

    private final BigDecimal amount;

    public PaymentRefundedEvent(String paymentId, BigDecimal amount) {
        super(paymentId);
        this.amount = amount;
    }

    public BigDecimal getAmount() { return amount; }
}