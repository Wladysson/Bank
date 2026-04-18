package com.bank.payments.domain.model;

import java.util.UUID;

public class PaymentId {

    private final String value;

    private PaymentId(String value) {
        this.value = value;
    }

    public static PaymentId generate() {
        return new PaymentId(UUID.randomUUID().toString());
    }

    public String getValue() {
        return value;
    }
}