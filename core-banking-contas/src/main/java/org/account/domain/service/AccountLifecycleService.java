package com.bank.account.domain.service;

import com.bank.account.domain.model.*;
import com.bank.account.domain.repository.AccountRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.math.BigDecimal;
import java.util.UUID;

@ApplicationScoped
public class AccountLifecycleService {

    @Inject
    AccountRepository accountRepository;

    public Account openAccount(UUID accountId,
                               String accountNumber,
                               AccountType type,
                               UUID primaryHolderId,
                               BigDecimal initialBalance) {

        if (accountRepository.existsByAccountNumber(accountNumber)) {
            throw new IllegalStateException("Conta já existe");
        }

        Account account = Account.open(
                accountId,
                accountNumber,
                type
        );

        if (initialBalance != null && initialBalance.compareTo(BigDecimal.ZERO) > 0) {
            account.deposit(initialBalance);
        }

        return accountRepository.save(account);
    }

    public void blockAccount(UUID accountId, String reason) {
        Account account = getAccount(accountId);
        account.block(reason);
        accountRepository.save(account);
    }

    public void closeAccount(UUID accountId) {
        Account account = getAccount(accountId);
        account.close();
        accountRepository.save(account);
    }

    private Account getAccount(UUID accountId) {
        return accountRepository.findById(accountId)
                .orElseThrow(() -> new IllegalArgumentException("Conta não encontrada"));
    }
}