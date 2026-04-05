package com.bank.ledger.domain.event;

import java.util.UUID;

public class PaymentPostingFailedEvent {

    private final UUID paymentId;
    private final String message;

    public PaymentPostingFailedEvent(UUID paymentId, String message) {
        this.paymentId = paymentId;
        this.message = message;
    }

    public UUID getPaymentId() {
        return paymentId;
    }

    public String getMessage() {
        return message;
    }
}