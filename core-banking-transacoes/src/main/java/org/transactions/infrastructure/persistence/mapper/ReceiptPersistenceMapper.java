package com.bank.transactions.infrastructure.persistence.mapper;

import com.bank.transactions.domain.model.common.Receipt;
import com.bank.transactions.infrastructure.persistence.entity.ReceiptEntity;

// Mapper responsável pela conversão de comprovantes
public class ReceiptPersistenceMapper {

    // Converte domínio para entidade
    public ReceiptEntity toEntity(Receipt receipt) {

        ReceiptEntity entity = new ReceiptEntity();

        entity.receiptId = receipt.getReceiptId();
        entity.transactionId = receipt.getTransactionId();
        entity.receiptUrl = receipt.getReceiptUrl();
        entity.generatedAt = receipt.getGeneratedAt();

        return entity;
    }

    // Converte entidade para domínio
    public Receipt toDomain(ReceiptEntity entity) {

        Receipt receipt = new Receipt();

        receipt.setReceiptId(entity.receiptId);
        receipt.setTransactionId(entity.transactionId);
        receipt.setReceiptUrl(entity.receiptUrl);

        return receipt;
    }
}