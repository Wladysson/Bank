package com.bank.transactions.domain.gateway.repository;

import com.bank.transactions.domain.model.common.Transaction;

import java.util.Optional;

// Repositório responsável pelas transações
public interface TransactionRepository {

    // Persiste transação
    Transaction save(Transaction transaction);

    // Busca transação por identificador
    Optional<Transaction> findById(String transactionId);

    // Atualiza status da transação
    void updateStatus(
            String transactionId,
            String status
    );
}