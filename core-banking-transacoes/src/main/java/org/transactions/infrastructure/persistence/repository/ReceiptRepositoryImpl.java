package com.bank.transactions.infrastructure.persistence.repository;

import com.bank.transactions.domain.gateway.repository.ReceiptRepository;
import com.bank.transactions.domain.model.common.Receipt;
import com.bank.transactions.infrastructure.persistence.entity.ReceiptEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.Optional;

// Implementação do repositório de comprovantes
@ApplicationScoped
public class ReceiptRepositoryImpl implements ReceiptRepository {

    // Persiste comprovante
    @Override
    @Transactional
    public Receipt save(Receipt receipt) {

        ReceiptEntity entity = new ReceiptEntity();

        entity.receiptId = receipt.getReceiptId();
        entity.transactionId = receipt.getTransactionId();
        entity.receiptUrl = receipt.getReceiptUrl();
        entity.generatedAt = receipt.getGeneratedAt();

        entity.persist();

        return receipt;
    }

    // Busca comprovante pelo identificador
    @Override
    public Optional<Receipt> findById(String receiptId) {

        ReceiptEntity.findById(receiptId);

        return Optional.empty();
    }
}