package com.bank.transactions.infrastructure.persistence.mapper;

import com.bank.transactions.domain.model.schedule.ScheduleStatus;
import com.bank.transactions.domain.model.schedule.ScheduledTransaction;
import com.bank.transactions.infrastructure.persistence.entity.ScheduledTransactionEntity;

// Mapper responsável pela conversão de agendamentos
public class SchedulePersistenceMapper {

    // Converte domínio para entidade JPA
    public ScheduledTransactionEntity toEntity(
            ScheduledTransaction scheduledTransaction
    ) {

        ScheduledTransactionEntity entity =
                new ScheduledTransactionEntity();

        entity.scheduleId =
                scheduledTransaction.getTransactionId().getValue();

        entity.sourceAccountId =
                scheduledTransaction.getSourceAccountId();

        entity.destinationIdentifier =
                scheduledTransaction.getDestinationIdentifier();

        entity.status =
                scheduledTransaction.getStatus().name();

        entity.scheduledAt =
                scheduledTransaction.getScheduledAt();

        entity.retryCount =
                scheduledTransaction.getRetryCount();

        return entity;
    }

    // Converte entidade JPA para domínio
    public ScheduledTransaction toDomain(
            ScheduledTransactionEntity entity
    ) {

        ScheduledTransaction scheduledTransaction =
                new ScheduledTransaction();

        scheduledTransaction.setSourceAccountId(
                entity.sourceAccountId
        );

        scheduledTransaction.setDestinationIdentifier(
                entity.destinationIdentifier
        );

        scheduledTransaction.setStatus(
                ScheduleStatus.valueOf(entity.status)
        );

        scheduledTransaction.setScheduledAt(
                entity.scheduledAt
        );

        return scheduledTransaction;
    }
}