package com.bank.account.account.domain.model;

import java.util.Objects;
import java.util.UUID;

public final class AccountId {

    private final UUID value;

    private AccountId(UUID value) {
        this.value = value;
    }

    // Factory method para criação segura
    public static AccountId newId() {
        return new AccountId(UUID.randomUUID());
    }

    public static AccountId of(UUID value) {
        if (value == null) {
            throw new IllegalArgumentException("AccountId cannot be null");
        }
        return new AccountId(value);
    }

    public UUID getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AccountId)) return false;
        AccountId that = (AccountId) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}