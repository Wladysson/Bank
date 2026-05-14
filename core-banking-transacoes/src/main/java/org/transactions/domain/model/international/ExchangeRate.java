package com.seubanco.transactions.domain.model.international;

import java.math.BigDecimal;

// Value Object responsável pela taxa cambial
public class ExchangeRate {

    // Valor da taxa de câmbio
    private final BigDecimal value;

    public ExchangeRate(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }
}