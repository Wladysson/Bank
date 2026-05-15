package com.bank.transactions.infrastructure.persistence.mapper;

import com.bank.transactions.domain.model.common.*;
import com.bank.transactions.infrastructure.persistence.entity.TransactionEntity;

import java.util.Currency;

// Mapper responsável pela conversão de transações
public class TransactionPersistenceMapper {

    // Converte domínio para entidade JPA
    public TransactionEntity toEntity(Transaction transaction) {

        TransactionEntity entity = new TransactionEntity();

        entity.transactionId =
                transaction.getTransactionId().getValue();

        entity.transactionType =
                transaction.getTransactionType().name();

        entity.status =
                transaction.getStatus().name();

        entity.amount =
                transaction.getAmount().getAmount();

        entity.currency =
                transaction.getAmount()
                        .getCurrency()
                        .getCurrencyCode();

        entity.channel =
                transaction.getChannel().name();

        entity.createdAt =
                transaction.getCreatedAt();

        entity.completedAt =
                transaction.getCompletedAt();

        return entity;
    }

    // Converte entidade JPA para domínio
    public Transaction toDomain(TransactionEntity entity) {

        Transaction transaction = new Transaction();

        transaction.setTransactionId(
                new TransactionId(entity.transactionId)
        );

        transaction.setTransactionType(
                TransactionType.valueOf(entity.transactionType)
        );

        transaction.setStatus(
                TransactionStatus.valueOf(entity.status)
        );

        transaction.setAmount(
                new Money(
                        entity.amount,
                        Currency.getInstance(entity.currency)
                )
        );

        transaction.setChannel(
                TransactionChannel.valueOf(entity.channel)
        );

        return transaction;
    }
}