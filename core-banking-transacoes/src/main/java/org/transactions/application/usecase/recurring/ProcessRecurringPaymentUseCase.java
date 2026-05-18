package com.bank.transactions.application.usecase.recurring;

import com.bank.transactions.application.service.RecurringPaymentService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ProcessRecurringPaymentUseCase {

    @Inject
    RecurringPaymentService recurringPaymentService;

    public void execute() {
        recurringPaymentService.processRecurringPayments();
    }
}