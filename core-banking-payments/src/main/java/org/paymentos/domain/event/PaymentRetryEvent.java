package com.bank.payments.domain.event;

public class PaymentRetryEvent extends PaymentEvent {

    private final int attempt;

    public PaymentRetryEvent(String paymentId, int attempt) {
        super(paymentId);
        this.attempt = attempt;
    }

    public int getAttempt() { return attempt; }
}