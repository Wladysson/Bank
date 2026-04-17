package com.bank.payments.application.usecase.batch;

import com.bank.payments.application.dto.response.BatchResponse;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BatchStatusUseCase {

    public BatchResponse execute(String batchId) {
        // TODO: buscar no repositório futuramente
        throw new UnsupportedOperationException("Batch status ainda não implementado");
    }
}