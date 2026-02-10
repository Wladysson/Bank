package com.bank.account.domain.service;

import com.bank.account.domain.model.Account;
import com.bank.account.domain.repository.AccountRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.math.BigDecimal;
import java.util.UUID;

@ApplicationScoped
public class BalanceManagementService {

    @Inject
    AccountRepository accountRepository;

    public void deposit(UUID accountId, BigDecimal amount) {
        Account account = getAccount(accountId);
        account.deposit(amount);
        accountRepository.save(account);
    }

    public void withdraw(UUID accountId, BigDecimal amount) {
        Account account = getAccount(accountId);
        account.withdraw(amount);
        accountRepository.save(account);
    }

    private Account getAccount(UUID accountId) {
        return accountRepository.findById(accountId)
                .orElseThrow(() -> new IllegalArgumentException("Conta não encontrada"));
    }
}