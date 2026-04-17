package com.bank.payments.application.service;

import com.bank.payments.domain.model.Payment;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FeeService {

    public void applyFees(Payment payment) {
        // TODO calcular taxas
    }
}