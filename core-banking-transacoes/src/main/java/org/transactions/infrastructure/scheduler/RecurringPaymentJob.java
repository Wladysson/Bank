package com.bank.transactions.infrastructure.scheduler;

import com.bank.transactions.application.usecase.recurring.ProcessRecurringPaymentUseCase;
import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

// Job responsável pelos pagamentos recorrentes
@ApplicationScoped
public class RecurringPaymentJob {

    @Inject
    ProcessRecurringPaymentUseCase processRecurringPaymentUseCase;

    @Scheduled(every = "1m")
    public void run() {
        processRecurringPaymentUseCase.execute();
    }
}