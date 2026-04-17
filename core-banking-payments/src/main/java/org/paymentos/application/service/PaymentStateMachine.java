package com.bank.payments.application.service;

import com.bank.payments.domain.model.Payment;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PaymentStateMachine {

    public void validateInitial(Payment payment) {
        if (payment == null) {
            throw new IllegalStateException("Payment cannot be null");
        }
    }
}