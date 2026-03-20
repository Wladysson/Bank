package com.bank.account.domain.model;

import java.math.BigDecimal;

public class Balance {

    private BigDecimal available;
    private BigDecimal current;

    public Balance(BigDecimal initial) {
        this.available = initial;
        this.current = initial;
    }

    public void deposit(BigDecimal amount) {
        validate(amount);
        current = current.add(amount);
        available = available.add(amount);
    }

    public void withdraw(BigDecimal amount) {
        validate(amount);
        if (available.compareTo(amount) < 0) {
            throw new IllegalStateException("Saldo insuficiente");
        }
        current = current.subtract(amount);
        available = available.subtract(amount);
    }

    public void reserve(BigDecimal amount) {
        validate(amount);
        if (available.compareTo(amount) < 0) {
            throw new IllegalStateException("Saldo insuficiente para reserva");
        }
        available = available.subtract(amount);
    }

    public void release(BigDecimal amount) {
        validate(amount);
        available = available.add(amount);
    }

    private void validate(BigDecimal amount) {
        if (amount == null || amount.signum() <= 0) {
            throw new IllegalArgumentException("Valor inválido");
        }
    }

    public BigDecimal getAvailable() { return available; }
    public BigDecimal getCurrent() { return current; }
}