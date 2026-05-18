package com.bank.transactions.application.usecase.pix;

import com.bank.transactions.application.dto.request.pix.ExecutePixTransferRequest;
import com.bank.transactions.application.dto.response.pix.PixTransactionResponse;
import com.bank.transactions.application.service.PixTransactionService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

// Use case responsável por executar transferências PIX
@ApplicationScoped
public class ExecutePixTransferUseCase {

    @Inject
    PixTransactionService pixTransactionService;

    // Orquestra a execução da transferência PIX
    public PixTransactionResponse execute(ExecutePixTransferRequest request) {
        return pixTransactionService.executeTransfer(request);
    }
}