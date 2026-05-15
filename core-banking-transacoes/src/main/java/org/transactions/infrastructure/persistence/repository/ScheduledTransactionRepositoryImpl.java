package com.bank.transactions.infrastructure.persistence.repository;

import com.bank.transactions.domain.gateway.repository.ScheduledTransactionRepository;
import com.bank.transactions.domain.model.schedule.ScheduledTransaction;
import com.bank.transactions.infrastructure.persistence.entity.ScheduledTransactionEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

// Implementação do repositório de agendamentos
@ApplicationScoped
public class ScheduledTransactionRepositoryImpl
        implements ScheduledTransactionRepository {

    // Persiste agendamento
    @Override
    @Transactional
    public ScheduledTransaction save(
            ScheduledTransaction scheduledTransaction
    ) {

        ScheduledTransactionEntity entity =
                new ScheduledTransactionEntity();

        entity.scheduleId =
                scheduledTransaction.getTransactionId().getValue();

        entity.status =
                scheduledTransaction.getStatus().name();

        entity.scheduledAt =
                scheduledTransaction.getScheduledAt();

        entity.retryCount =
                scheduledTransaction.getRetryCount();

        entity.persist();

        return scheduledTransaction;
    }

    // Busca agendamento por id
    @Override
    public Optional<ScheduledTransaction> findById(
            String scheduleId
    ) {

        ScheduledTransactionEntity.findById(scheduleId);

        return Optional.empty();
    }

    // Lista agendamentos pendentes
    @Override
    public List<ScheduledTransaction> findPendingTransactions() {
        return Collections.emptyList();
    }
}