package com.bank.transactions.application.service;

import com.bank.transactions.application.dto.request.schedule.RetryScheduledTransactionRequest;
import com.bank.transactions.application.dto.request.schedule.ScheduleTransactionRequest;
import com.bank.transactions.application.dto.response.schedule.ScheduledTransactionResponse;
import jakarta.enterprise.context.ApplicationScoped;

// Serviço responsável por transações agendadas
@ApplicationScoped
public class ScheduledTransactionService {

    // Agenda nova transação
    public ScheduledTransactionResponse schedule(ScheduleTransactionRequest request) {
        return new ScheduledTransactionResponse();
    }

    // Processa transação agendada
    public void processScheduledTransaction(String scheduledTransactionId) {

    }

    // Reprocessa transação com falha
    public ScheduledTransactionResponse retryTransaction(RetryScheduledTransactionRequest request) {
        return new ScheduledTransactionResponse();
    }

    // Cancela agendamento
    public void cancelScheduledTransaction(String scheduledTransactionId) {

    }
}