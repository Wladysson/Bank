package com.bank.transactions.application.usecase.pix;

import com.seubanco.transactions.application.dto.request.pix.RefundPixTransactionRequest;
import com.seubanco.transactions.application.dto.response.pix.PixTransactionResponse;
import com.seubanco.transactions.application.service.PixTransactionService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

// Use case responsável pelo estorno de transações PIX
@ApplicationScoped
public class RefundPixTransactionUseCase {

    @Inject
    PixTransactionService pixTransactionService;

    // Executa processo de devolução do PIX
    public PixTransactionResponse execute(RefundPixTransactionRequest request) {
        return pixTransactionService.refundTransaction(request);
    }
}