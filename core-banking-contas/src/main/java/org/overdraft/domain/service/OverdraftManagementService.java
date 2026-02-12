package com.bank.account.domain.service;

import com.bank.account.domain.model.Account;
import com.bank.account.domain.model.OverdraftLimit;
import com.bank.account.domain.repository.AccountRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.math.BigDecimal;
import java.util.UUID;

@ApplicationScoped
public class OverdraftManagementService {

    @Inject
    AccountRepository accountRepository;

    public void useOverdraft(UUID accountId, BigDecimal amount) {
        Account account = getAccount(accountId);

        OverdraftLimit overdraft = account.getOverdraftLimit();
        if (overdraft == null) {
            throw new IllegalStateException("Conta sem limite de cheque especial");
        }

        overdraft.use(amount);
        accountRepository.save(account);
    }

    public void repayOverdraft(UUID accountId, BigDecimal amount) {
        Account account = getAccount(accountId);

        OverdraftLimit overdraft = account.getOverdraftLimit();
        if (overdraft == null) {
            throw new IllegalStateException("Conta sem limite de cheque especial");
        }

        overdraft.repay(amount);
        accountRepository.save(account);
    }

    private Account getAccount(UUID accountId) {
        return accountRepository.findById(accountId)
                .orElseThrow(() -> new IllegalArgumentException("Conta não encontrada"));
    }
}