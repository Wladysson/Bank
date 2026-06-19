package com.bank.account.balance.domain.service;

import com.bank.account.balance.domain.exception.InsufficientAvailableBalanceException;
import com.bank.account.domain.model.Balance;
import com.bank.account.balance.domain.model.BalanceAvailability;

import java.math.BigDecimal;

public class BalanceAvailabilityService {

    public BalanceAvailability calculateAvailability(
            Balance balance
    ) {

        return new BalanceAvailability(
                "UNKNOWN",               // TODO obter accountId real
                balance.getCurrent(),
                balance.getReserved()
        );
    }

    public void validateAvailableBalance(
            Balance balance,
            BigDecimal amount
    ) {

        BalanceAvailability availability =
                calculateAvailability(balance);

        if (!availability.hasAvailableBalance(amount)) {

            throw new InsufficientAvailableBalanceException(
                    "UNKNOWN",            // TODO obter accountId real
                    amount,
                    availability.getAvailableBalance()
            );
        }
    }

    public boolean canReserveAmount(
            Balance balance,
            BigDecimal amount
    ) {

        return calculateAvailability(balance)
                .hasAvailableBalance(amount);
    }

    public BigDecimal getAvailableBalance(
            Balance balance
    ) {

        return calculateAvailability(balance)
                .getAvailableBalance();
    }
}