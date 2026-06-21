package com.bank.account.hold.domain.model;

import java.util.Objects;
import java.util.UUID;

public class HoldId {

    private final String value; // identificador único da reserva

    public HoldId() {
        this.value = UUID.randomUUID().toString(); // gera identificador automaticamente
    }

    public HoldId(String value) {

        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Hold id cannot be null or blank");
        }

        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (!(o instanceof HoldId)) {
            return false;
        }

        HoldId holdId = (HoldId) o;

        return Objects.equals(value, holdId.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }
}