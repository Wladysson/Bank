package com.bank.transactions.application.usecase.recurring;

import com.seubanco.transactions.application.dto.request.recurring.CreateRecurringPaymentRequest;
import com.seubanco.transactions.application.dto.response.recurring.RecurringPaymentResponse;
import com.seubanco.transactions.application.service.RecurringPaymentService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

// Use case responsável pela criação de pagamentos recorrentes
@ApplicationScoped
public class CreateRecurringPaymentUseCase {

    @Inject
    RecurringPaymentService recurringPaymentService;

    // Cria uma nova recorrência de pagamento
    public RecurringPaymentResponse execute(CreateRecurringPaymentRequest request) {
        return recurringPaymentService.createRecurringPayment(request);
    }
}