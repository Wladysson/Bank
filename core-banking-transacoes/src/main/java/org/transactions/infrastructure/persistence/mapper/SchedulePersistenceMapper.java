package com.bank.transactions.infrastructure.persistence.mapper;

import com.bank.transactions.domain.model.schedule.ScheduleStatus;
import com.bank.transactions.domain.model.schedule.ScheduledTransaction;
import com.bank.transactions.domain.model.common.TransactionStatus;
import com.bank.transactions.infrastructure.persistence.entity.ScheduledTransactionEntity;

public class SchedulePersistenceMapper {

    public ScheduledTransactionEntity toEntity(
            ScheduledTransaction scheduledTransaction
    ) {

        ScheduledTransactionEntity entity = new ScheduledTransactionEntity();

        entity.scheduleId = scheduledTransaction.getTransactionId().getValue();
        entity.sourceAccountId = scheduledTransaction.getSourceAccountId();
        entity.destinationIdentifier = scheduledTransaction.getDestinationIdentifier();

        // ✔ converte ScheduleStatus -> String
        entity.status = scheduledTransaction.getStatus().name();

        entity.scheduledAt = scheduledTransaction.getScheduledAt();
        entity.retryCount = scheduledTransaction.getRetryCount();

        return entity;
    }

    public ScheduledTransaction toDomain(
            ScheduledTransactionEntity entity
    ) {

        ScheduledTransaction scheduledTransaction = new ScheduledTransaction();

        scheduledTransaction.setSourceAccountId(entity.sourceAccountId);
        scheduledTransaction.setDestinationIdentifier(entity.destinationIdentifier);

        // ✔ aqui está o ponto crítico do erro
        scheduledTransaction.markAsCompleted(); // exemplo

        scheduledTransaction.setScheduledAt(entity.scheduledAt);

        return scheduledTransaction;
    }
}