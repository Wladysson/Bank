package com.bank.account.account.domain.model;

import java.util.Objects;

    //Value Object que representa o código da agência (branch) da conta.
    //Responsável por garantir padronização e validação do identificador da unidade bancária.

public final class BranchCode {

    private final String value;

    private BranchCode(String value) {
        this.value = value;
    }

    public static BranchCode of(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("BranchCode cannot be null or blank");
        }

        if (!value.matches("\\d{4,6}")) { // valida padrão comum de agência bancária
            throw new IllegalArgumentException("BranchCode must contain 4 to 6 digits");
        }

        return new BranchCode(value);
    }

    public String getValue() {
        return value; // retorna o código da agência no formato string
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; //comparação por referência rápida
        if (!(o instanceof BranchCode)) return false;
        BranchCode that = (BranchCode) o;
        return Objects.equals(value, that.value); //igualdade baseada no valor
    }

    @Override
    public int hashCode() {
        return Objects.hash(value); // hash consistente para uso em collections
    }

    @Override
    public String toString() {
        return value; //representação legível do branch code
    }
}