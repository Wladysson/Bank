package com.bank.payments.domain.event;

import com.bank.payments.domain.model.PixPayment;
import java.time.OffsetDateTime;
import java.util.UUID;

public record PixPaymentCompletedEvent(
        UUID paymentId,
        String txId,
        String endToEndId,
        OffsetDateTime occurredAt
) {

    public static PixPaymentCompletedEvent from(PixPayment payment) {
        return new PixPaymentCompletedEvent(
                payment.getId(),
                payment.getTxId(),
                payment.getEndToEndId(),
                OffsetDateTime.now()
        );
    }
}