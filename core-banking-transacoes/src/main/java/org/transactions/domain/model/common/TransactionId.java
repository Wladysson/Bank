package com.bank.transactions.domain.model.common;

// Value Object responsável pelo identificador transacional
public class TransactionId {

    private final String value;

    public TransactionId(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}