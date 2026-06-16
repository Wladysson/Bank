package com.bank.account.balance.application.mapper;

import com.bank.account.balance.application.dto.AvailableBalanceDTO;
import com.bank.account.balance.application.dto.BalanceResponseDTO;
import com.bank.account.balance.domain.model.Balance;
import com.bank.account.balance.domain.model.BalanceAvailability;

import java.math.BigDecimal;

public final class BalanceMapper {

    private BalanceMapper() {
    }

    public static BalanceResponseDTO toResponseDTO(
            Balance balance
    ) {

        BalanceResponseDTO dto = new BalanceResponseDTO();

        dto.setAccountId(balance.getAccountId()); // identifica a conta consultada
        dto.setCurrentBalance(balance.getCurrentBalance()); // saldo total da conta
        dto.setReservedBalance(balance.getReservedBalance()); // saldo reservado

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
        ); // converte agregação de disponibilidade para DTO
    }

    public static BigDecimal calculateAvailableBalance(
            Balance balance
    ) {

        return balance.getCurrentBalance()
                .subtract(balance.getReservedBalance()); // calcula saldo disponível
    }
}