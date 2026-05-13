package com.bank.transactions.application.usecase.pix;

import com.seubanco.transactions.application.dto.response.pix.PixTransactionResponse;
import com.seubanco.transactions.application.service.PixTransactionService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

// Use case responsável por consultar status da transação PIX
@ApplicationScoped
public class GetPixTransactionStatusUseCase {

    @Inject
    PixTransactionService pixTransactionService;

    // Busca status atualizado da transação
    public PixTransactionResponse execute(String transactionId) {
        return pixTransactionService.getTransactionStatus(transactionId);
    }
}