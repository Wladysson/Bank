package com.bank.account.domain.service;

import com.bank.account.domain.model.AccountLimit;
import com.bank.account.domain.repository.AccountLimitRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.math.BigDecimal;
import java.util.UUID;

@ApplicationScoped
public class ValidationService {

    @Inject
    AccountLimitRepository limitRepository;

    public void validatePixLimit(UUID accountId, BigDecimal amount) {
        AccountLimit limit = getLimit(accountId);

        if (amount.compareTo(limit.getPixDailyLimit()) > 0) {
            throw new RuntimeException("Pix limit exceeded");
        }
    }

    public void validateWithdrawLimit(UUID accountId, BigDecimal amount) {
        AccountLimit limit = getLimit(accountId);

        if (amount.compareTo(limit.getWithdrawDailyLimit()) > 0) {
            throw new RuntimeException("Withdraw limit exceeded");
        }
    }

    public void validateTedLimit(UUID accountId, BigDecimal amount) {
        AccountLimit limit = getLimit(accountId);

        if (amount.compareTo(limit.getTedDailyLimit()) > 0) {
            throw new RuntimeException("TED limit exceeded");
        }
    }

    private AccountLimit getLimit(UUID accountId) {
        return limitRepository.findByAccountId(accountId)
                .orElseThrow(() -> new RuntimeException("Limits not configured"));
    }
}