package com.bank.transactions.domain.gateway.receipt;

import com.bank.transactions.domain.model.common.Receipt;

// Gateway responsável pelo armazenamento de comprovantes
public interface ReceiptStorageGateway {

    // Armazena comprovante gerado
    String store(Receipt receipt);

    // Recupera comprovante armazenado
    Receipt findByReceiptId(String receiptId);

    // Remove comprovante do storage
    void delete(String receiptId);
}