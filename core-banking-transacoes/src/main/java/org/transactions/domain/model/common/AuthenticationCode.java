package com.bank.transactions.domain.model.common;

import java.util.UUID;

// Value Object responsável pela autenticação transacional
public class AuthenticationCode {

    private final String value;

    public AuthenticationCode() {
        this.value = UUID.randomUUID().toString();
    }

    public String getValue() {
        return value;
    }
}