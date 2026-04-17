package com.bank.payments.application.service;

import com.bank.payments.domain.model.Payment;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LimitCheckService {

    public void check(Payment payment) {
        // TODO validar limite do usuário
    }
}