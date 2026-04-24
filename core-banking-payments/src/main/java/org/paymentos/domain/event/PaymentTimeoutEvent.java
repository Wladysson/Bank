package com.bank.payments.domain.event;

import com.bank.payments.domain.model.Payment;

public class PaymentTimeoutEvent extends PaymentEvent {

    public PaymentTimeoutEvent(Payment payment) {
        super(payment.getId());
    }
}