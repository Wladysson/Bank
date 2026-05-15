package com.bank.transactions.domain.gateway.repository;

import com.bank.transactions.domain.model.common.Receipt;

import java.util.Optional;

// Repositório responsável pelos comprovantes
public interface ReceiptRepository {

    // Persiste comprovante
    Receipt save(Receipt receipt);

    // Busca comprovante pelo identificador
    Optional<Receipt> findById(String receiptId);
}