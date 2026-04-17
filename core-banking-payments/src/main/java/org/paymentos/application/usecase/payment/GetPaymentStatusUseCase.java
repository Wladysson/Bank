package com.bank.payments.application.usecase.payment;

import com.bank.payments.application.dto.response.PaymentStatusResponse;
import com.bank.payments.application.service.PaymentOrchestratorService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class GetPaymentStatusUseCase {

    @Inject
    PaymentOrchestratorService orchestratorService;

    public PaymentStatusResponse execute(String paymentId) {
        return orchestratorService.getPaymentStatus(paymentId);
    }
}