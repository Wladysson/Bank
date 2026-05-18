package com.bank.transactions.domain.model.international;

import com.bank.transactions.domain.model.common.Money;

// Value Object responsável pela conversão monetária
public class CurrencyConversion {

    // Valor original
    private final Money sourceAmount;

    // Valor convertido
    private final Money convertedAmount;

    // Taxa aplicada
    private final ExchangeRate exchangeRate;

    public CurrencyConversion(
            Money sourceAmount,
            Money convertedAmount,
            ExchangeRate exchangeRate
    ) {
        this.sourceAmount = sourceAmount;
        this.convertedAmount = convertedAmount;
        this.exchangeRate = exchangeRate;
    }

    public Money getSourceAmount() {
        return sourceAmount;
    }

    public Money getConvertedAmount() {
        return convertedAmount;
    }

    public ExchangeRate getExchangeRate() {
        return exchangeRate;
    }
}