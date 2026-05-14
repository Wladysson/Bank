package com.bank.transactions.domain.model.validation;

import java.math.BigDecimal;

// Value Object responsável pela validação de saldo
public class BalanceValidationResult {

    // Indica se existe saldo suficiente
    private final boolean valid;

    // Saldo disponível na conta
    private final BigDecimal availableBalance;

    // Valor solicitado na operação
    private final BigDecimal requestedAmount;

    public BalanceValidationResult(
            boolean valid,
            BigDecimal availableBalance,
            BigDecimal requestedAmount
    ) {
        this.valid = valid;
        this.availableBalance = availableBalance;
        this.requestedAmount = requestedAmount;
    }

    // Verifica se saldo cobre a operação
    public boolean hasSufficientBalance() {
        return valid;
    }

    public boolean isValid() {
        return valid;
    }

    public BigDecimal getAvailableBalance() {
        return availableBalance;
    }

    public BigDecimal getRequestedAmount() {
        return requestedAmount;
    }
}