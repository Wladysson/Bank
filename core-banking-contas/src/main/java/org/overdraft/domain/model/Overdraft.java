package com.bank.account.domain.model;

import java.math.BigDecimal;

public class Overdraft{

    private BigDecimal limit;
    private BigDecimal used;

    public Overdraft(BigDecimal limit) {
        this.limit = limit;
        this.used = BigDecimal.ZERO;
    }

    public void use(BigDecimal amount) {
        if (used.add(amount).compareTo(limit) > 0) {
            throw new IllegalStateException("Limite de cheque especial excedido");
        }
        used = used.add(amount);
    }

    public void repay(BigDecimal amount) {
        used = used.subtract(amount);
        if (used.signum() < 0) {
            used = BigDecimal.ZERO;
        }
    }

    public BigDecimal getAvailable() {
        return limit.subtract(used);
    }
}