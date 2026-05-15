package com.bank.transactions.infrastructure.persistence.repository;

import com.bank.transactions.domain.gateway.repository.RecurringPaymentRepository;
import com.bank.transactions.domain.model.recurring.RecurringPayment;
import com.bank.transactions.infrastructure.persistence.entity.RecurringPaymentEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

// Implementação do repositório de recorrências
@ApplicationScoped
public class RecurringPaymentRepositoryImpl
        implements RecurringPaymentRepository {

    // Persiste pagamento recorrente
    @Override
    @Transactional
    public RecurringPayment save(
            RecurringPayment recurringPayment
    ) {

        RecurringPaymentEntity entity =
                new RecurringPaymentEntity();

        entity.recurringPaymentId =
                recurringPayment.getRecurringPaymentId();

        entity.status =
                recurringPayment.getStatus().name();

        entity.frequency =
                recurringPayment.getFrequency().name();

        entity.nextExecutionDate =
                recurringPayment.getNextExecutionDate();

        entity.persist();

        return recurringPayment;
    }

    // Busca recorrência pelo identificador
    @Override
    public Optional<RecurringPayment> findById(
            String recurringPaymentId
    ) {

        RecurringPaymentEntity.findById(recurringPaymentId);

        return Optional.empty();
    }

    // Lista recorrências ativas
    @Override
    public List<RecurringPayment> findActivePayments() {
        return Collections.emptyList();
    }
}