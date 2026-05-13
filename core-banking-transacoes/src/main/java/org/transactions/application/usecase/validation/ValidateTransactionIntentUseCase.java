package com.bank.transactions.application.usecase.validation;

import com.seubanco.transactions.application.service.TransactionIntentValidationService;
import com.seubanco.transactions.domain.model.validation.TransactionIntent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

// Use case responsável por validar intenção transacional
@ApplicationScoped
public class ValidateTransactionIntentUseCase {

    @Inject
    TransactionIntentValidationService validationService;

    // Executa validações antifraude e comportamento transacional
    public boolean execute(TransactionIntent transactionIntent) {
        return validationService.validate(transactionIntent);
    }
}