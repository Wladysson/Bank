package com.bank.account.application.service;

import com.bank.account.application.command.OpenAccountCommand;
import com.bank.account.domain.model.Account;
import com.bank.account.domain.model.AccountType;
import com.bank.account.domain.repository.AccountRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.UUID;

@ApplicationScoped
public class AccountOpeningService {

    @Inject
    AccountRepository accountRepository;

    public Account open(OpenAccountCommand command) {

        Account account = Account.open(
                UUID.randomUUID(),
                generateAccountNumber(),
                AccountType.valueOf(command.getAccountType().toUpperCase())
        );

        accountRepository.save(account);

        return account;
    }

    private String generateAccountNumber() {
        return "ACC-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}