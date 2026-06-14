package com.bank.account.domain.model;

import java.util.Objects;
import java.util.UUID;

public final class AccountNumber {

    private final String value;

    private AccountNumber(String value) {
        this.value = value;
    }


      //Geração básica de número de conta.
      //na produção, isso deve vir de AccountNumberGenerator (policy/service).

    public static AccountNumber generate() {
        return new AccountNumber("ACCT-" + UUID.randomUUID().toString().substring(0, 10).toUpperCase());
    }

    public static AccountNumber of(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("AccountNumber cannot be null or blank");
        }
        return new AccountNumber(value);
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AccountNumber)) return false;
        AccountNumber that = (AccountNumber) o;
        return Objects.equals(value, that.value);
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