package com.bank.transactions.application.usecase.schedule;

import com.seubanco.transactions.application.service.ScheduledTransactionService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

// Use case responsável pelo processamento de transações agendadas
@ApplicationScoped
public class ProcessScheduledTransactionUseCase {

    @Inject
    ScheduledTransactionService scheduledTransactionService;

    // Executa processamento da transação agendada
    public void execute(String scheduledTransactionId) {
        scheduledTransactionService.processScheduledTransaction(scheduledTransactionId);
    }
}