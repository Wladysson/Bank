package com.bank.transactions.application.usecase.recurring;

import com.seubanco.transactions.application.dto.request.recurring.CancelRecurringPaymentRequest;
import com.seubanco.transactions.application.service.RecurringPaymentService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

// Use case responsável pelo cancelamento de recorrências
@ApplicationScoped
public class CancelRecurringPaymentUseCase {

    @Inject
    RecurringPaymentService recurringPaymentService;

    // Cancela definitivamente o pagamento recorrente
    public void execute(CancelRecurringPaymentRequest request) {
        recurringPaymentService.cancelRecurringPayment(request);
    }
}