package com.bank.account.balance.interfaces.rest.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AccountBalanceResponse {

    private String accountId; // identificador da conta

    private String accountNumber; // número da conta

    private BigDecimal currentBalance; // saldo total contabilizado

    private BigDecimal reservedBalance; // saldo reservado por holds

    private BigDecimal availableBalance; // saldo disponível para movimentação

    private String currency; // moeda da conta

    private LocalDateTime lastUpdatedAt; // última atualização do saldo

    public AccountBalanceResponse() {
    }

    public AccountBalanceResponse(
            String accountId,
            String accountNumber,
            BigDecimal currentBalance,
            BigDecimal reservedBalance,
            BigDecimal availableBalance,
            String currency,
            LocalDateTime lastUpdatedAt
    ) {
        this.accountId = accountId;
        this.accountNumber = accountNumber;
        this.currentBalance = currentBalance;
        this.reservedBalance = reservedBalance;
        this.availableBalance = availableBalance;
        this.currency = currency;
        this.lastUpdatedAt = lastUpdatedAt;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public LocalDateTime getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public void setLastUpdatedAt(LocalDateTime lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }
}