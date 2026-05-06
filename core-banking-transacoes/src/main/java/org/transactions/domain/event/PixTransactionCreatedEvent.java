package com.bank.transactions.domain.event;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

public record PixTransactionCreatedEvent(
        UUID transactionId,
        BigDecimal amount,
        OffsetDateTime occurredAt
) {

    public static PixTransactionCreatedEvent from(PixTransaction transaction) {
        return new PixTransactionCreatedEvent(
                transaction.getId(),
                transaction.getAmount(),
                OffsetDateTime.now()
        );
    }
}