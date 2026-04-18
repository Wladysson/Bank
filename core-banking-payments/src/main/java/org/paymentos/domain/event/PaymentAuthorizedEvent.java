package com.bank.payments.domain.event;

public class PaymentAuthorizedEvent extends PaymentEvent {

    public PaymentAuthorizedEvent(String paymentId) {
        super(paymentId);
    }
}