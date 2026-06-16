package com.bank.account.balance.application.dto;

import java.math.BigDecimal;

public class AvailableBalanceDTO {

    private String accountId; // identificador da conta

    private BigDecimal currentBalance; // saldo total contabilizado

    private BigDecimal reservedBalance; // saldo reservado em holds

    private BigDecimal availableBalance; // saldo efetivamente disponível

    public AvailableBalanceDTO() {
    }

    public AvailableBalanceDTO(
            String accountId,
            BigDecimal currentBalance,
            BigDecimal reservedBalance,
            BigDecimal availableBalance
    ) {
        this.accountId = accountId;
        this.currentBalance = currentBalance;
        this.reservedBalance = reservedBalance;
        this.availableBalance = availableBalance;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }

    public BigDecimal getReservedBalance() {
        return reservedBalance;
    }

    public void setReservedBalance(BigDecimal reservedBalance) {
        this.reservedBalance = reservedBalance;
    }

    public BigDecimal getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(BigDecimal availableBalance) {
        this.availableBalance = availableBalance;
    }
}