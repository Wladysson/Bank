package com.bank.account.balance.domain.model;

import java.math.BigDecimal;

public class BalanceAvailability {

    private final String accountId; // identificador da conta

    private final BigDecimal currentBalance; // saldo total contabilizado

    private final BigDecimal reservedBalance; // saldo reservado por holds

    private final BigDecimal availableBalance; // saldo efetivamente disponível

    public BalanceAvailability(
            String accountId,
            BigDecimal currentBalance,
            BigDecimal reservedBalance
    ) {

        this.accountId = accountId;
        this.currentBalance = currentBalance;
        this.reservedBalance = reservedBalance;
        this.availableBalance =
                currentBalance.subtract(reservedBalance); // calcula saldo disponível
    }

    public String getAccountId() {
        return accountId;
    }

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public BigDecimal getReservedBalance() {
        return reservedBalance;
    }

    public BigDecimal getAvailableBalance() {
        return availableBalance;
    }

    public boolean hasAvailableBalance(BigDecimal amount) {

        return availableBalance.compareTo(amount) >= 0; // verifica disponibilidade para operação
    }

    public boolean hasReservedFunds() {

        return reservedBalance.compareTo(BigDecimal.ZERO) > 0; // verifica existência de reservas
    }
}