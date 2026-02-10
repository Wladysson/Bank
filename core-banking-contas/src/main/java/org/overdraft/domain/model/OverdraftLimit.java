package com.bank.account.domain.model;

import java.math.BigDecimal;
import java.util.Objects;

public class OverdraftLimit {

    private BigDecimal limit;
    private BigDecimal used;

    public OverdraftLimit(BigDecimal limit) {
        validate(limit);
        this.limit = limit;
        this.used = BigDecimal.ZERO;
    }

    public void increaseLimit(BigDecimal amount) {
        validate(amount);
        this.limit = this.limit.add(amount);
    }

    public void decreaseLimit(BigDecimal amount) {
        validate(amount);
        if (limit.subtract(amount).compareTo(used) < 0) {
            throw new IllegalStateException("Novo limite menor que o valor já utilizado");
        }
        this.limit = this.limit.subtract(amount);
    }

    public void use(BigDecimal amount) {
        validate(amount);

        if (getAvailable().compareTo(amount) < 0) {
            throw new IllegalStateException("Limite de cheque especial excedido");
        }

        this.used = this.used.add(amount);
    }

    public void repay(BigDecimal amount) {
        validate(amount);

        this.used = this.used.subtract(amount);

        if (this.used.signum() < 0) {
            this.used = BigDecimal.ZERO;
        }
    }

    public BigDecimal getAvailable() {
        return limit.subtract(used);
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public BigDecimal getUsed() {
        return used;
    }

    private void validate(BigDecimal value) {
        if (Objects.isNull(value) || value.signum() <= 0) {
            throw new IllegalArgumentException("Valor inválido");
        }
    }
}