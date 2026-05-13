package com.bank.transactions.application.service;

import com.bank.transactions.application.dto.response.receipt.TransactionReceiptResponse;
import jakarta.enterprise.context.ApplicationScoped;

// Serviço responsável pela geração e consulta de comprovantes
@ApplicationScoped
public class ReceiptService {

    // Gera comprovante da transação
    public TransactionReceiptResponse generateReceipt(String transactionId) {
        return new TransactionReceiptResponse();
    }

    // Busca comprovante já emitido
    public TransactionReceiptResponse getReceipt(String receiptId) {
        return new TransactionReceiptResponse();
    }
}