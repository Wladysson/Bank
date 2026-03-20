package com.bank.account.application.service;

import com.bank.account.application.command.OpenAccountCommand;
import com.bank.account.domain.model.Account;
import com.bank.account.domain.repository.AccountRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class AccountOpeningService {

    @Inject
    AccountRepository accountRepository;

    public void open(OpenAccountCommand command) {

        Account account = Account.open(
                command.getCustomerId(),
                command.getAccountType(),
                command.getCurrency()
        );

        accountRepository.save(account);

        // depósito inicial pode virar evento pro para o livro de referencia
    }
}