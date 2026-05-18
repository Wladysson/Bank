package com.bank.transactions.domain.model.international;

import java.math.BigDecimal;
import java.time.LocalDateTime;

// Entidade responsável pela cotação cambial
public class ExchangeQuote {

    // Moeda de origem
    private String sourceCurrency;

    // Moeda de destino
    private String targetCurrency;

    // Taxa cambial aplicada
    private BigDecimal rate;

    // Data da cotação
    private LocalDateTime quotedAt;

    public ExchangeQuote() {
        this.quotedAt = LocalDateTime.now();
    }

    // CONSTRUTOR CORRETO
    public ExchangeQuote(
            String sourceCurrency,
            String targetCurrency,
            BigDecimal rate,
            LocalDateTime quotedAt
    ) {
        this.sourceCurrency = sourceCurrency;
        this.targetCurrency = targetCurrency;
        this.rate = rate;
        this.quotedAt = quotedAt;
    }

    public String getSourceCurrency() {
        return sourceCurrency;
    }

    public void setSourceCurrency(String sourceCurrency) {
        this.sourceCurrency = sourceCurrency;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }

    public void setTargetCurrency(String targetCurrency) {
        this.targetCurrency = targetCurrency;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public LocalDateTime getQuotedAt() {
        return quotedAt;
    }
}