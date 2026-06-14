package com.bank.account.domain.model;

import java.util.Objects;
import java.util.UUID;


 //Value Object que representa o identificador do cliente (CustomerId).
 //Usado para vincular contas a clientes externos (Customer Service / Core Customer Domain).

public final class CustomerId {

    private final UUID value;

    private CustomerId(UUID value) {
        this.value = value;
    }

     //Criação a partir de UUID validado.

    public static CustomerId of(UUID value) {
        if (value == null) {
            throw new IllegalArgumentException("CustomerId cannot be null");
        }

        return new CustomerId(value);
    }


     //Criação a partir de string UUID (entrada externa).

    public static CustomerId fromString(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("CustomerId cannot be null or blank");
        }

        return new CustomerId(UUID.fromString(value)); // garante formato UUID válido
    }

    public UUID getValue() {
        return value; // expõe o identificador interno tipado
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; //  otimização de comparação por referência
        if (!(o instanceof CustomerId)) return false;
        CustomerId that = (CustomerId) o;
        return Objects.equals(value, that.value); //  comparação por valor real
    }

    @Override
    public int hashCode() {
        return Objects.hash(value); // hash consistente para uso em mapas e sets
    }

    @Override
    public String toString() {
        return value.toString(); // saída padrão para logs e tracing
    }
}