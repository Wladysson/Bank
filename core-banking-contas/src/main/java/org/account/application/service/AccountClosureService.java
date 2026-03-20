package com.bank.account.application.service;

import com.bank.account.application.command.CloseAccountCommand;
import com.bank.account.domain.model.Account;
import com.bank.account.domain.repository.AccountRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Optional;

@ApplicationScoped
public class AccountClosureService {

    @Inject
    AccountRepository accountRepository;

    public void close(CloseAccountCommand command) {

        Optional<Account> accountOpt = accountRepository.findById(command.getAccountId());

        if (accountOpt.isEmpty()) {
            throw new RuntimeException("Account not found");
        }

        Account account = accountOpt.get();

        account.close();

        accountRepository.save(account);
    }
}