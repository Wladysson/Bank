package com.bank.payments.domain.event;

import com.bank.payments.domain.model.Payment;

public class PaymentRequestedEvent extends PaymentEvent {

    private final Payment payment;

    public PaymentRequestedEvent(Payment payment) {
        super(payment.getId());
        this.payment = payment;
    }

    public Payment getPayment() {
        return payment;
    }
}