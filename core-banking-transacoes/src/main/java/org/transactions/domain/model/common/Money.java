package com.bank.transactions.domain.model.common;

import java.math.BigDecimal;
import java.util.Currency;

// Value Object monetário do domínio
public class Money {

    // Valor financeiro
    private final BigDecimal amount;

    // Moeda utilizada
    private final Currency currency;

    public Money(BigDecimal amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    // Soma valores monetários
    public Money add(Money other) {
        return new Money(
                this.amount.add(other.amount),
                this.currency
        );
    }

    // Subtrai valores monetários
    public Money subtract(Money other) {
        return new Money(
                this.amount.subtract(other.amount),
                this.currency
        );
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }
}