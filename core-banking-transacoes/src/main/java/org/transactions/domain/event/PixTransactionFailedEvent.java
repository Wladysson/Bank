package com.bank.transactions.domain.event;

import java.time.OffsetDateTime;
import java.util.UUID;

public record PixTransactionFailedEvent(
        UUID transactionId,
        String reason,
        OffsetDateTime occurredAt
) {

    public static PixTransactionFailedEvent from(
            PixTransaction transaction,
            String reason
    ) {
        return new PixTransactionFailedEvent(
                transaction.getId(),
                reason,
                OffsetDateTime.now()
        );
    }
}