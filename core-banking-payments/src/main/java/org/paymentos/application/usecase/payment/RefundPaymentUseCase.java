package com.bank.payments.application.usecase.payment;

import com.bank.payments.application.dto.request.RefundRequest;
import com.bank.payments.application.dto.response.PaymentResponse;
import com.bank.payments.application.service.PaymentOrchestratorService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class RefundPaymentUseCase {

    @Inject
    PaymentOrchestratorService orchestratorService;

    @Transactional
    public PaymentResponse execute(RefundRequest request) {
        return orchestratorService.refundPayment(request);
    }
}