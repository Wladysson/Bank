package com.bank.payments.domain.event;

public class ChargebackOpenedEvent extends PaymentEvent {

    private final String reason;

    public ChargebackOpenedEvent(String paymentId, String reason) {
        super(paymentId);
        this.reason = reason;
    }

    public String getReason() { return reason; }
}