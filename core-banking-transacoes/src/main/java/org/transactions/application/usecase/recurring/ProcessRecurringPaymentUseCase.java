package com.bank.transactions.application.usecase.recurring;

import com.bank.transactions.application.service.RecurringPaymentService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

// Use case responsável pelo processamento automático de recorrências
@ApplicationScoped
public class ProcessRecurringPaymentUseCase {

    @Inject
    RecurringPaymentService recurringPaymentService;

    // Processa todas as cobranças recorrentes pendentes
    public void execute() {
        recurringPaymentService.processRecurringPayments();
    }
}