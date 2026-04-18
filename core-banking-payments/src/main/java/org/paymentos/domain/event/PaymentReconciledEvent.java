package com.bank.payments.domain.event;

public class PaymentReconciledEvent extends PaymentEvent {

    public PaymentReconciledEvent(String paymentId) {
        super(paymentId);
    }
}