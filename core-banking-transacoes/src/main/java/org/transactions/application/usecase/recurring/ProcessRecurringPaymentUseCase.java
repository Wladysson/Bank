package com.bank.transactions.application.usecase.recurring;

import com.seubanco.transactions.application.service.RecurringPaymentService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

// Use case responsável pelo processamento automático de recorrências
@ApplicationScoped
public class ProcessRecurringPaymentUseCase {

    @Inject
    RecurringPaymentService recurringPaymentService;

    // Processa execução da cobrança recorrente
    public void execute(String recurringPaymentId) {
        recurringPaymentService.processRecurringPayment(recurringPaymentId);
    }
}