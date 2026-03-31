package com.bank.account.domain.model;

import java.math.BigDecimal;

public class AccountLimit {

    private BigDecimal dailyTransferLimit;
    private BigDecimal dailyWithdrawLimit;
    private BigDecimal monthlyTransferLimit;
    private BigDecimal dailyWithdrawalLimit;
    private BigDecimal tedDailyLimit;

    public AccountLimit(BigDecimal dailyTransferLimit,
                        BigDecimal dailyWithdrawLimit,
                        BigDecimal monthlyTransferLimit) {

        this.dailyTransferLimit = dailyTransferLimit;
        this.dailyWithdrawLimit = dailyWithdrawLimit;
        this.monthlyTransferLimit = monthlyTransferLimit;
    }

    public void validateTransfer(BigDecimal amount) {
        if (amount.compareTo(dailyTransferLimit) > 0) {
            throw new IllegalStateException("Limite diário de transferência excedido");
        }
    }

    public void validateWithdraw(BigDecimal amount) {
        if (amount.compareTo(dailyWithdrawLimit) > 0) {
            throw new IllegalStateException("Limite diário de saque excedido");
        }
    }

    public BigDecimal getDailyWithdrawLimit() {
        return dailyWithdrawLimit;
    }

    public BigDecimal getDailyWithdrawalLimit() {
        return dailyWithdrawalLimit;
    }

    public BigDecimal getTedDailyLimit() {
        return tedDailyLimit;
    }
}