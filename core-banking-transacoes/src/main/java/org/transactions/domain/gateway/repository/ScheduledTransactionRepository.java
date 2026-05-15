package com.bank.transactions.domain.gateway.repository;

import com.bank.transactions.domain.model.schedule.ScheduledTransaction;

import java.util.List;
import java.util.Optional;

// Repositório responsável pelos agendamentos
public interface ScheduledTransactionRepository {

    // Salva agendamento
    ScheduledTransaction save(
            ScheduledTransaction scheduledTransaction
    );

    // Busca agendamento por identificador
    Optional<ScheduledTransaction> findById(String scheduleId);

    // Lista agendamentos pendentes
    List<ScheduledTransaction> findPendingTransactions();
}