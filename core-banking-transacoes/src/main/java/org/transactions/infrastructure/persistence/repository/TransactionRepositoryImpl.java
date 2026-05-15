package com.bank.transactions.infrastructure.persistence.repository;

import com.bank.transactions.domain.gateway.repository.TransactionRepository;
import com.bank.transactions.domain.model.common.Transaction;
import com.bank.transactions.infrastructure.persistence.entity.TransactionEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.Optional;

// Implementação do repositório de transações
@ApplicationScoped
public class TransactionRepositoryImpl implements TransactionRepository {

    // Persiste transação no banco
    @Override
    @Transactional
    public Transaction save(Transaction transaction) {

        TransactionEntity entity = new TransactionEntity();

        entity.transactionId = transaction.getTransactionId().getValue();
        entity.transactionType = transaction.getTransactionType().name();
        entity.status = transaction.getStatus().name();
        entity.amount = transaction.getAmount().getAmount();
        entity.currency = transaction.getAmount().getCurrency().getCurrencyCode();
        entity.createdAt = transaction.getCreatedAt();

        entity.persist();

        return transaction;
    }

    // Busca transação pelo identificador
    @Override
    public Optional<Transaction> findById(String transactionId) {

        TransactionEntity entity =
                TransactionEntity.findById(transactionId);

        return Optional.empty();
    }

    // Atualiza status transacional
    @Override
    @Transactional
    public void updateStatus(
            String transactionId,
            String status
    ) {

        TransactionEntity entity =
                TransactionEntity.findById(transactionId);

        if (entity != null) {
            entity.status = status;
        }
    }
}