package com.bank.payments.application.usecase.cashback;

import com.bank.payments.domain.model.Payment;

import jakarta.enterprise.context.ApplicationScoped;

import java.math.BigDecimal;

@ApplicationScoped
public class ApplyCashbackUseCase {

    private static final BigDecimal CASHBACK_PERCENTAGE = new BigDecimal("0.02"); // 2%

    public BigDecimal execute(Payment payment) {

        // regra simples (depois você evolui)
        if (payment.getAmount() == null) {
            return BigDecimal.ZERO;
        }

        BigDecimal cashback = payment.getAmount().multiply(CASHBACK_PERCENTAGE);

        // aqui futuramente:
        // - enviar pro wallet service
        // - gerar evento
        // - creditar usuário

        return cashback;
    }
}