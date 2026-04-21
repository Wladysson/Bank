package com.bank.payments.domain.service;

import com.bank.payments.domain.model.Payment;

import java.math.BigDecimal;

public class FreeCalculationService {

    private static final BigDecimal DEFAULT_FEE = new BigDecimal("0.02"); // 2%

    public BigDecimal calculate(Payment payment) {

        if (payment.getAmount() == null) {
            return BigDecimal.ZERO;
        }

        return payment.getAmount().multiply(DEFAULT_FEE);
    }
}