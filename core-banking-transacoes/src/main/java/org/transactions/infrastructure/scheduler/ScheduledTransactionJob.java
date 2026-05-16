package com.bank.transactions.infrastructure.scheduler;

import com.banktransactions.application.service.ScheduledTransactionService;
import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

// Job responsável pelo processamento de agendamentos
@ApplicationScoped
public class ScheduledTransactionJob {

    @Inject
    ScheduledTransactionService scheduledTransactionService;

    // Executa processamento a cada 1 minuto
    @Scheduled(every = "60s")
    void processScheduledTransactions() {

        scheduledTransactionService
                .processPendingTransactions();
    }
}