package com.bank.payments.application.service;

import com.bank.payments.domain.model.Payment;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FraudCheckService {

    public void check(Payment payment) {
        // TODO integrar antifraude real
    }
}