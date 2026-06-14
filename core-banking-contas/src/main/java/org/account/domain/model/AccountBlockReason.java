package com.bank.account.domain.model;

import java.util.Objects;


 //Value Object que representa o motivo pelo qual uma conta foi bloqueada

public final class AccountBlockReason {

    private final String value;

    private AccountBlockReason(String value) {
        this.value = value;
    }

    public static AccountBlockReason of(String value) {
        if (value == null || value.isBlank()) { // validação básica do motivo
            throw new IllegalArgumentException("AccountBlockReason cannot be null or blank");
        }

        return new AccountBlockReason(value.trim()); // normaliza entrada do motivo
    }

    public String getValue() {
        return value; // retorna o motivo do bloqueio
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // comparação por referência
        if (!(o instanceof AccountBlockReason)) return false;
        AccountBlockReason that = (AccountBlockReason) o;
        return Objects.equals(value, that.value); // comparação por valor
    }

    @Override
    public int hashCode() {
        return Objects.hash(value); // hash baseado no motivo
    }

    @Override
    public String toString() {
        return value; // representação textual do motivo
    }
}