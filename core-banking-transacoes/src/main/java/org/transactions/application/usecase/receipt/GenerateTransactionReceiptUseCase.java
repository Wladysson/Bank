package com.bank.transactions.application.usecase.receipt;

import com.bank.transactions.application.dto.response.receipt.TransactionReceiptResponse;
import com.bank.transactions.application.service.ReceiptService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

// Use case responsável pela geração de comprovantes
@ApplicationScoped
public class GenerateTransactionReceiptUseCase {

    @Inject
    ReceiptService receiptService;

    // Gera comprovante da transação processada
    public TransactionReceiptResponse execute(String transactionId) {
        return receiptService.generateReceipt(transactionId);
    }
}