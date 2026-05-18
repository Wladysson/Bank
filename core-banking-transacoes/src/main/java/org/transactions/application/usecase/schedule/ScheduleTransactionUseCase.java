package com.bank.transactions.application.usecase.schedule;

import com.bank.transactions.application.dto.request.schedule.ScheduleTransactionRequest;
import com.bank.transactions.application.dto.response.schedule.ScheduledTransactionResponse;
import com.bank.transactions.application.service.ScheduledTransactionService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

// Use case responsável pelo agendamento de transações
@ApplicationScoped
public class ScheduleTransactionUseCase {

    @Inject
    ScheduledTransactionService scheduledTransactionService;

    // Agenda uma nova transação para execução futura
    public ScheduledTransactionResponse execute(ScheduleTransactionRequest request) {
        return scheduledTransactionService.schedule(request);
    }
}