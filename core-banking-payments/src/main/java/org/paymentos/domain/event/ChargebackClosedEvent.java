package com.bank.payments.domain.event;

public class ChargebackClosedEvent extends PaymentEvent {

    private final boolean accepted;

    public ChargebackClosedEvent(String paymentId, boolean accepted) {
        super(paymentId);
        this.accepted = accepted;
    }

    public boolean isAccepted() { return accepted; }
}