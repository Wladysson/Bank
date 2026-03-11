package com.bank.ledger.domain.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {
    private final BigDecimal value;
    private final String currency;

    public Money(BigDecimal value, String currency) {
        this.value = Objects.requireNonNull(value);
        this.currency = Objects.requireNonNull(currency);
    }

    public BigDecimal getValue() {
        return value;
    }

    public String getCurrency() {
        return currency;
    }

    public Money add(Money other) {
        if (!this.currency.equals(other.currency)) {
            throw new IllegalArgumentException("Currency mismatch");
        }
        return new Money(this.value.add(other.value), this.currency);
    }

    public Money subtract(Money other) {
        if (!this.currency.equals(other.currency)) {
            throw new IllegalArgumentException("Currency mismatch");
        }
        return new Money(this.value.subtract(other.value), this.currency);
    }
}