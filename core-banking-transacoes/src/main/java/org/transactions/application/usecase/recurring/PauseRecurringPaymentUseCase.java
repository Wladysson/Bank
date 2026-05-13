package com.bank.transactions.application.usecase.recurring;

import com.seubanco.transactions.application.service.RecurringPaymentService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

// Use case responsável por pausar pagamentos recorrentes
@ApplicationScoped
public class PauseRecurringPaymentUseCase {

    @Inject
    RecurringPaymentService recurringPaymentService;

    // Suspende temporariamente a recorrência
    public void execute(String recurringPaymentId) {
        recurringPaymentService.pauseRecurringPayment(recurringPaymentId);
    }
}