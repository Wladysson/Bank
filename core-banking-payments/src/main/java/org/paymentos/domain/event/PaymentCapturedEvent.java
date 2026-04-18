package com.bank.payments.domain.event;

public class PaymentCapturedEvent extends PaymentEvent {

    public PaymentCapturedEvent(String paymentId) {
        super(paymentId);
    }
}