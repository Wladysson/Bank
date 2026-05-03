package com.bank.payments.domain.event;

import com.bank.payments.domain.model.PixPayment;
import java.time.OffsetDateTime;
import java.util.UUID;

public record PixPaymentFailedEvent(
        UUID paymentId,
        String txId,
        String reason,
        OffsetDateTime occurredAt
) {

    public static PixPaymentFailedEvent from(PixPayment payment, String reason) {
        return new PixPaymentFailedEvent(
                payment.getId(),
                payment.getTxId(),
                reason,
                OffsetDateTime.now()
        );
    }
}