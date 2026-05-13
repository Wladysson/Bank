package com.bank.transactions.domain.event;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

public record PixTransactionCompletedEvent(
        UUID transactionId,
        String endToEndId,
        BigDecimal amount,
        OffsetDateTime occurredAt
) {

    public static PixTransactionCompletedEvent from(PixTransaction transaction) {
        return new PixTransactionCompletedEvent(
                transaction.getId(),
                transaction.getEndToEndId(),
                transaction.getAmount(),
                OffsetDateTime.now()
        );
    }
}