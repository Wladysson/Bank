package com.bank.account.balance.application.mapper;

import com.bank.account.balance.application.dto.AvailableBalanceDTO;
import com.bank.account.application.dto.BalanceResponseDTO;
import com.bank.account.domain.model.Balance;
import com.bank.account.balance.domain.model.BalanceAvailability;

import java.math.BigDecimal;

public final class BalanceMapper {

    private BalanceMapper() {
    }

    public static BalanceResponseDTO toResponseDTO(
            Balance balance
    ) {

        BalanceResponseDTO dto = new BalanceResponseDTO();

        // Sua entidade Balance não possui accountId
        // portanto não há como preencher esse campo

        dto.setAvailableBalance(
                balance.getAvailable()
        );

        dto.setReservedBalance(
                balance.getReserved()
        );

        dto.setTotalBalance(
                balance.getCurrent()
        );

        dto.setCurrency(
                balance.getCurrency()
        );

        return dto;
    }

    public static AvailableBalanceDTO toAvailableBalanceDTO(
            BalanceAvailability availability
    ) {

        return new AvailableBalanceDTO(
                availability.getAccountId(),
                availability.getCurrentBalance(),
                availability.getReservedBalance(),
                availability.getAvailableBalance()
        );
    }

    public static BigDecimal calculateAvailableBalance(
            Balance balance
    ) {

        return balance.getCurrent()
                .subtract(balance.getReserved());
    }
}