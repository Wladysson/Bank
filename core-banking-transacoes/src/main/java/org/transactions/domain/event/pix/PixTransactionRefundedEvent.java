package com.bank.transactions.domain.event;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

public record PixTransactionRefundedEvent(
        UUID refundTransactionId,
        UUID originalTransactionId,
        BigDecimal amount,
        OffsetDateTime occurredAt
) {

    public static PixTransactionRefundedEvent from(
            PixTransaction refundTransaction,
            PixTransaction originalTransaction
    ) {
        return new PixTransactionRefundedEvent(
                refundTransaction.getId(),
                originalTransaction.getId(),
                refundTransaction.getAmount(),
                OffsetDateTime.now()
        );
    }
}