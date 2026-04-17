package com.bank.payments.application.usecase.payment;

import com.bank.payments.application.service.PaymentOrchestratorService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ValidatePaymentUseCase {

    @Inject
    PaymentOrchestratorService orchestratorService;

    public void execute(ProcessPaymentCommand command) {
        orchestratorService.validatePayment(command);
    }
}