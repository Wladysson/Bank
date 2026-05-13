package com.bank.transactions.application.usecase.receipt;

import com.bank.transactions.application.dto.response.receipt.TransactionReceiptResponse;
import com.bank.transactions.application.service.ReceiptService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

// Use case responsável pela consulta de comprovantes
@ApplicationScoped
public class GetTransactionReceiptUseCase {

    @Inject
    ReceiptService receiptService;

    // Busca comprovante previamente gerado
    public TransactionReceiptResponse execute(String receiptId) {
        return receiptService.getReceipt(receiptId);
    }
}