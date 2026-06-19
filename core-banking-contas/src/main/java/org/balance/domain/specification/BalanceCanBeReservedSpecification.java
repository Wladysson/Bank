package com.bank.account.balance.domain.specification;

import com.bank.account.balance.domain.model.Balance;

import java.math.BigDecimal;

public class BalanceCanBeReservedSpecification {

    public boolean isSatisfiedBy(
            Balance balance,
            BigDecimal amount
    ) {

        if (balance == null) {
            return false; // impede validação sobre saldo inexistente
        }

        if (amount == null) {
            return false; // impede validação sem valor informado
        }

        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            return false; // reservas devem possuir valor positivo
        }

        BigDecimal availableBalance =
                balance.getCurrentBalance()
                        .subtract(balance.getReservedBalance()); // calcula saldo disponível

        return availableBalance.compareTo(amount) >= 0; // valida disponibilidade para reserva
    }
}