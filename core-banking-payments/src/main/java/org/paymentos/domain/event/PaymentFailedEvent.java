package com.bank.payments.domain.event;

public class PaymentFailedEvent extends PaymentEvent {

    private final String reason;

    public PaymentFailedEvent(String paymentId, String reason) {
        super(paymentId);
        this.reason = reason;
    }

    public String getReason() { return reason; }
}