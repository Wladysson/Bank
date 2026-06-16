package com.bank.account.application.service;

import com.bank.account.domain.model.Account;
import com.bank.account.domain.repository.AccountRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class AccountSearchService {

    private final AccountRepository accountRepository;

    @Inject
    public AccountSearchService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Optional<Account> findById(UUID accountId) {
        return accountRepository.findById(accountId);
    }
}