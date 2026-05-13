package com.bank.transactions.application.usecase.pix;

import com.seubanco.transactions.application.service.PixTransactionService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

// Use case responsável por confirmar liquidação do PIX
@ApplicationScoped
public class ConfirmPixSettlementUseCase {

    @Inject
    PixTransactionService pixTransactionService;

    // Confirma que a liquidação foi concluída pelo BACEN/provedor
    public void execute(String transactionId) {
        pixTransactionService.confirmSettlement(transactionId);
    }
}