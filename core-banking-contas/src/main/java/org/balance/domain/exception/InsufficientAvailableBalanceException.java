package com.bank.account.balance.domain.exception;

import java.math.BigDecimal;

public class InsufficientAvailableBalanceException extends RuntimeException {

    private final String accountId; // conta que tentou realizar a operação

    private final BigDecimal requestedAmount; // valor solicitado

    private final BigDecimal availableAmount; // saldo disponível no momento

    public InsufficientAvailableBalanceException(
            String accountId,
            BigDecimal requestedAmount,
            BigDecimal availableAmount
    ) {

        super(
                String.format(
                        "Insufficient available balance. Account=%s Requested=%s Available=%s",
                        accountId,
                        requestedAmount,
                        availableAmount
                )
        ); // monta mensagem padronizada da exceção

        this.accountId = accountId;
        this.requestedAmount = requestedAmount;
        this.availableAmount = availableAmount;
    }

    public String getAccountId() {
        return accountId;
    }

    public BigDecimal getRequestedAmount() {
        return requestedAmount;
    }

    public BigDecimal getAvailableAmount() {
        return availableAmount;
    }
}