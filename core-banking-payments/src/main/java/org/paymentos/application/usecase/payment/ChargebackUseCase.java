package com.bank.payments.application.usecase.payment;

import com.bank.payments.application.service.PaymentOrchestratorService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ChargebackUseCase {

    @Inject
    PaymentOrchestratorService orchestratorService;

    @Transactional
    public void execute(String paymentId, String reason) {
        orchestratorService.processChargeback(paymentId, reason);
    }
}