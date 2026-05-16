package com.bank.transactions.infrastructure.scheduler;

import com.bank.transactions.application.service.RecurringPaymentService;
import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

// Job responsável pelos pagamentos recorrentes
@ApplicationScoped
public class RecurringPaymentJob {

    @Inject
    RecurringPaymentService recurringPaymentService;

    // Executa processamento recorrente
    @Scheduled(every = "24h")
    void processRecurringPayments() {

        recurringPaymentService
                .processRecurringPayments();
    }
}