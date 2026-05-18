package com.bank.transactions.application.service;

import com.bank.transactions.application.dto.request.recurring.CancelRecurringPaymentRequest;
import com.bank.transactions.application.dto.request.recurring.CreateRecurringPaymentRequest;
import com.bank.transactions.application.dto.response.recurring.RecurringPaymentResponse;
import jakarta.enterprise.context.ApplicationScoped;

// Serviço responsável pelo gerenciamento de recorrências
@ApplicationScoped
public class RecurringPaymentService {

    // Cria pagamento recorrente
    public RecurringPaymentResponse createRecurringPayment(CreateRecurringPaymentRequest request) {
        return new RecurringPaymentResponse();
    }

    public void processRecurringPayments() {
        // 1. buscar todos pendentes no banco
        // 2. iterar e chamar processRecurringPayment
    }

    // Executa cobrança recorrente
    public void processRecurringPayment(String recurringPaymentId) {

    }

    // Pausa recorrência
    public void pauseRecurringPayment(String recurringPaymentId) {

    }

    // Cancela recorrência
    public void cancelRecurringPayment(CancelRecurringPaymentRequest request) {

    }
}