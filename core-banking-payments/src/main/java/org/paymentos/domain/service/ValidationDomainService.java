package com.bank.payments.domain.service;

import com.bank.payments.domain.model.Payment;

import java.math.BigDecimal;

public class ValidationDomainService {

    public void validate(Payment payment) {

        if (payment.getPayerId() == null || payment.getPayerId().isEmpty()) {
            throw new IllegalArgumentException("Payer obrigatorio");
        }

        if (payment.getPayeeId() == null || payment.getPayeeId().isEmpty()) {
            throw new IllegalArgumentException("Payee obrigatorio");
        }

        if (payment.getAmount() == null ||
                payment.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Valor invalido");
        }

        if (payment.getCurrency() == null) {
            throw new IllegalArgumentException("Moeda obrigatoria");
        }
    }
}