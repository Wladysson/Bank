package com.bank.payments.application.usecase.batch;

import com.bank.payments.application.dto.request.BatchPaymentRequest;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ValidateBatchUseCase {

    private static final int MAX_BATCH_SIZE = 1000;

    public void execute(BatchPaymentRequest request) {

        if (request == null || request.getPayments() == null || request.getPayments().isEmpty()) {
            throw new IllegalArgumentException("Batch vazio");
        }

        if (request.getPayments().size() > MAX_BATCH_SIZE) {
            throw new IllegalArgumentException("Batch excede o limite permitido");
        }
    }
}