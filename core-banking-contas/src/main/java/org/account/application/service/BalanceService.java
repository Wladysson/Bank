package com.bank.account.application.service;

import com.bank.account.domain.model.Balance;
import com.bank.account.application.dto.BalanceResponseDTO;
import com.bank.account.domain.repository.BalanceRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.UUID;

@ApplicationScoped
public class BalanceService {

    @Inject
    BalanceRepository balanceRepository;

    public BalanceResponseDTO getBalance(UUID accountId) {

        var balance = balanceRepository.findByAccountId(accountId)
                .orElseThrow(() -> new RuntimeException("Balance não encontrado para accountId: " + accountId));

        BalanceResponseDTO dto = new BalanceResponseDTO();
        dto.setAccountId(accountId);
        dto.setAvailableBalance(balance.getAvailable());
        dto.setReservedBalance(balance.getReserved());
        dto.setTotalBalance(balance.getTotal());
        dto.setCurrency(balance.getCurrency());

        return dto;
    }
}