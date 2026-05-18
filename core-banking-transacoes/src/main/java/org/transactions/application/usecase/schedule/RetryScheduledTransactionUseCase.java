package com.bank.transactions.application.usecase.schedule;

import com.bank.transactions.application.dto.request.schedule.RetryScheduledTransactionRequest;
import com.bank.transactions.application.dto.response.schedule.ScheduledTransactionResponse;
import com.bank.transactions.application.service.ScheduledTransactionService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

// Use case responsável por reprocessar transações agendadas com falha
@ApplicationScoped
public class RetryScheduledTransactionUseCase {

    @Inject
    ScheduledTransactionService scheduledTransactionService;

    // Executa nova tentativa da transação agendada
    public ScheduledTransactionResponse execute(RetryScheduledTransactionRequest request) {
        return scheduledTransactionService.retryTransaction(request);
    }
}