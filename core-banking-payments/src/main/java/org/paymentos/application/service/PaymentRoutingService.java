package com.bank.payments.application.service;

import com.bank.payments.domain.model.Payment;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PaymentRoutingService {

    public void route(Payment payment) {
        // TODO escolher gateway (Cielo, Stripe, etc)
    }
}