package com.bank.account.domain.service;

import com.bank.account.domain.model.Account;
import com.bank.account.domain.model.HoldBalance;
import com.bank.account.domain.repository.AccountRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.math.BigDecimal;
import java.util.UUID;

@ApplicationScoped
public class HoldManagementService {

    @Inject
    AccountRepository accountRepository;

    public HoldBalance reserve(UUID accountId, BigDecimal amount) {
        Account account = getAccount(accountId);
        HoldBalance hold = account.reserveAmount(amount);//BLOQUEIO
        accountRepository.save(account);
        return hold;
    }

    public void release(UUID accountId, UUID holdId) {
        Account account = getAccount(accountId);
        account.releaseHold(holdId);
        accountRepository.save(account);
    }

    private Account getAccount(UUID accountId) {
        return accountRepository.findById(accountId)
                .orElseThrow(() -> new IllegalArgumentException("Conta não encontrada"));
    }
}