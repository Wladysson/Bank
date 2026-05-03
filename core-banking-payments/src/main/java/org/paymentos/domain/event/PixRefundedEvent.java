package com.bank.payments.domain.event;

import com.bank.payments.domain.model.PixPayment;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

public record PixRefundedEvent(
        UUID paymentId,
        String txId,
        BigDecimal refundedAmount,
        OffsetDateTime occurredAt
) {

    public static PixRefundedEvent from(PixPayment payment, BigDecimal refundedAmount) {
        return new PixRefundedEvent(
                payment.getId(),
                payment.getTxId(),
                refundedAmount,
                OffsetDateTime.now()
        );
    }
}