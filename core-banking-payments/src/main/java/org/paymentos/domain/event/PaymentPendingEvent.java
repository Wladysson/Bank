package com.bank.payments.domain.event;

public class PaymentPendingEvent extends PaymentEvent {

    public PaymentPendingEvent(String paymentId) {
        super(paymentId);
    }
}