package com.bank.payments.domain.event;

import java.time.LocalDateTime;

public abstract class PaymentEvent {

    protected final String paymentId;
    protected final LocalDateTime occurredAt;

    protected PaymentEvent(String paymentId) {
        this.paymentId = paymentId;
        this.occurredAt = LocalDateTime.now();
    }

    public String getPaymentId() { return paymentId; }
    public LocalDateTime getOccurredAt() { return occurredAt; }
}