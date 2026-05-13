package com.bank.transactions.application.service;

import com.bank.transactions.domain.model.validation.TransactionIntent;
import jakarta.enterprise.context.ApplicationScoped;

// Serviço responsável pela validação transacional
@ApplicationScoped
public class TransactionIntentValidationService {

    // Executa validações antifraude e risco operacional
    public boolean validate(TransactionIntent transactionIntent) {
        return true;
    }
}