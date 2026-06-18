package com.bank.account.balance.domain.service;

import com.bank.account.balance.domain.exception.InsufficientAvailableBalanceException;
import com.bank.account.balance.domain.model.Balance;
import com.bank.account.balance.domain.model.BalanceAvailability;

import java.math.BigDecimal;

public class BalanceAvailabilityService {

    public BalanceAvailability calculateAvailability(
            Balance balance
    ) {

        return new BalanceAvailability(
                balance.getAccountId(),
                balance.getCurrentBalance(),
                balance.getReservedBalance()
        ); // calcula visão consolidada do saldo disponível
    }

    public void validateAvailableBalance(
            Balance balance,
            BigDecimal amount
    ) {

        BalanceAvailability availability =
                calculateAvailability(balance); // obtém disponibilidade atual

        if (!availability.hasAvailableBalance(amount)) {

            throw new InsufficientAvailableBalanceException(
                    balance.getAccountId(),
                    amount,
                    availability.getAvailableBalance()
            ); // impede consumo acima do saldo disponível
        }
    }

    public boolean canReserveAmount(
            Balance balance,
            BigDecimal amount
    ) {

        return calculateAvailability(balance)
                .hasAvailableBalance(amount); // verifica possibilidade de reserva
    }

    public BigDecimal getAvailableBalance(
            Balance balance
    ) {

        return calculateAvailability(balance)
                .getAvailableBalance(); // retorna saldo disponível calculado
    }
}