package com.bank.account.domain.service;

import com.bank.account.domain.model.Account;
import com.bank.account.domain.model.AccountLimit;
import com.bank.account.domain.repository.AccountRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.math.BigDecimal;
import java.util.UUID;

@ApplicationScoped
public class LimitValidationService {

    @Inject
    AccountRepository accountRepository;

    public void validateTransfer(UUID accountId, BigDecimal amount) {
        Account account = getAccount(accountId);

        AccountLimit limit = account.getAccountLimit();
        if (limit == null) {
            return;
        }

        limit.validateTransfer(amount);
    }

    public void validateWithdraw(UUID accountId, BigDecimal amount) {
        Account account = getAccount(accountId);

        AccountLimit limit = account.getAccountLimit();
        if (limit == null) {
            return;
        }

        limit.validateWithdraw(amount);
    }

    private Account getAccount(UUID accountId) {
        return accountRepository.findById(accountId)
                .orElseThrow(() -> new IllegalArgumentException("Conta não encontrada"));
    }
}