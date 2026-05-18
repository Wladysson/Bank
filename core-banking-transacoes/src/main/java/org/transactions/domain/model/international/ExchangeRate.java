package com.bank.transactions.domain.model.international;

import java.math.BigDecimal;

// Value Object responsável pela taxa cambial
public class ExchangeRate {

    private String sourceCurrency;
    private String targetCurrency;
    private BigDecimal value;

    public ExchangeRate(String sourceCurrency, String targetCurrency, BigDecimal value) {
        this.sourceCurrency = sourceCurrency;
        this.targetCurrency = targetCurrency;
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }
}