package com.bank.payments.domain.event;

public class PaymentCreatedEvent extends PaymentEvent {

    public PaymentCreatedEvent(String paymentId) {
        super(paymentId);
    }
}