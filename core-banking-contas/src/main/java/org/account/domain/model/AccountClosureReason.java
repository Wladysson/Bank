package com.bank.account.account.domain.model;

import java.util.Objects;

 //Value Object que representa o motivo pelo qual uma conta foi encerrada

public final class AccountClosureReason {

    private final String value;

    private AccountClosureReason(String value) {
        this.value = value;
    }

    public static AccountClosureReason of(String value) {
        if (value == null || value.isBlank()) { // validação do motivo de encerramento
            throw new IllegalArgumentException("AccountClosureReason cannot be null or blank");
        }

        return new AccountClosureReason(value.trim()); // normaliza motivo de encerramento
    }

    public String getValue() {
        return value; // retorna motivo de encerramento
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // comparação por referência
        if (!(o instanceof AccountClosureReason)) return false;
        AccountClosureReason that = (AccountClosureReason) o;
        return Objects.equals(value, that.value); // comparação por valor
    }

    @Override
    public int hashCode() {
        return Objects.hash(value); // hash baseado no valor
    }

    @Override
    public String toString() {
        return value; // representação textual do encerramento
    }
}