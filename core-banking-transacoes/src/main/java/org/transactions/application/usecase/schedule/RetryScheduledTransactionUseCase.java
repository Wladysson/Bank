package com.bank.transactions.application.usecase.schedule;

import com.seubanco.transactions.application.dto.request.schedule.RetryScheduledTransactionRequest;
import com.seubanco.transactions.application.dto.response.schedule.ScheduledTransactionResponse;
import com.seubanco.transactions.application.service.ScheduledTransactionService;
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