package com.bank.account.application.service;

import com.bank.account.domain.model.Account;
import com.bank.account.domain.repository.AccountRepository;

import java.util.Optional;
import java.util.UUID;

public class AccountSearchService {

    private final AccountRepository accountRepository;

    public AccountSearchService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository; // injeta repositório de contas
    }

    public Optional<Account> findById(UUID accountId) {
        return accountRepository.findById(accountId); // busca conta por ID
    }
}