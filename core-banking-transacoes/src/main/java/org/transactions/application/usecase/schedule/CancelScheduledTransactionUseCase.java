package com.bank.transactions.application.usecase.schedule;

import com.seubanco.transactions.application.service.ScheduledTransactionService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

// Use case responsável pelo cancelamento de agendamentos
@ApplicationScoped
public class CancelScheduledTransactionUseCase {

    @Inject
    ScheduledTransactionService scheduledTransactionService;

    // Cancela uma transação agendada antes da execução
    public void execute(String scheduledTransactionId) {
        scheduledTransactionService.cancelScheduledTransaction(scheduledTransactionId);
    }
}