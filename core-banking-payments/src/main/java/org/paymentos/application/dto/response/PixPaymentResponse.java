package com.bank.payments.application.dto.response;

import com.bank.payments.domain.model.PixPayment;
import com.bank.payments.domain.model.PixStatus;
import com.bank.payments.domain.model.PixTransactionType;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

public record PixPaymentResponse(
        UUID id,
        String txId,
        String endToEndId,
        PixStatus status,
        BigDecimal amount,
        String receiverKey,
        PixTransactionType transactionType,
        OffsetDateTime createdAt,
        OffsetDateTime completedAt,
        String message
) {

    public static PixPaymentResponse from(PixPayment pixPayment) {
        return new PixPaymentResponse(
                pixPayment.getId(),
                pixPayment.getTxId(),
                pixPayment.getEndToEndId(),
                pixPayment.getStatus(),
                pixPayment.getAmount(),
                pixPayment.getReceiverKey().getValue(),
                pixPayment.getTransactionType(),
                pixPayment.getCreatedAt(),
                pixPayment.getCompletedAt(),
                "PIX operation processed successfully"
        );
    }

    public static PixPaymentResponse success(PixPayment pixPayment, String message) {
        return new PixPaymentResponse(
                pixPayment.getId(),
                pixPayment.getTxId(),
                pixPayment.getEndToEndId(),
                pixPayment.getStatus(),
                pixPayment.getAmount(),
                pixPayment.getReceiverKey().getValue(),
                pixPayment.getTransactionType(),
                pixPayment.getCreatedAt(),
                pixPayment.getCompletedAt(),
                message
        );
    }
}