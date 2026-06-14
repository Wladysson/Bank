package com.bank.account.account.domain.model;

import java.util.Objects;


 //Value Object que representa o motivo associado a mudanças de status da conta

public final class AccountStatusReason {

    private final String value;

    private AccountStatusReason(String value) {
        this.value = value;
    }

    public static AccountStatusReason of(String value) {
        if (value == null || value.isBlank()) { // validação do motivo de alteração de status
            throw new IllegalArgumentException("AccountStatusReason cannot be null or blank");
        }

        return new AccountStatusReason(value.trim()); // normaliza o motivo de status
    }

    public String getValue() {
        return value; // retorna o motivo da mudança de status
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // comparação por referência
        if (!(o instanceof AccountStatusReason)) return false;
        AccountStatusReason that = (AccountStatusReason) o;
        return Objects.equals(value, that.value); // comparação por valor
    }

    @Override
    public int hashCode() {
        return Objects.hash(value); // hash consistente para coleções
    }

    @Override
    public String toString() {
        return value; // representação textual do motivo
    }
}