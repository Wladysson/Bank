package com.bank.payments.domain.event;

import com.bank.payments.domain.model.PixPayment;
import java.time.OffsetDateTime;
import java.util.UUID;

public record PixPaymentCreatedEvent(
        UUID paymentId,
        String txId,
        String endToEndId,
        OffsetDateTime occurredAt
) {

    public static PixPaymentCreatedEvent from(PixPayment payment) {
        return new PixPaymentCreatedEvent(
                payment.getId(),
                payment.getTxId(),
                payment.getEndToEndId(),
                OffsetDateTime.now()
        );
    }
}