package com.bank.account.domain.service;

import com.bank.account.domain.model.OverdraftLimit;
import com.bank.account.domain.repository.AccountRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.math.BigDecimal;
import java.util.UUID;

@ApplicationScoped
public class OverdraftService {

    @Inject
    AccountRepository accountRepository;

    public boolean canUseOverdraft(UUID accountId, BigDecimal amount) {

        var account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        OverdraftLimit overdraft = account.getOverdraftLimit();

        if (overdraft == null || !overdraft.isEnabled()) {
            return false;
        }

        BigDecimal available = account.getBalance().getAvailable();

        // Se não tem saldo suficiente, verifica se pode usar overdraft
        BigDecimal deficit = amount.subtract(available);

        return deficit.compareTo(overdraft.getLimit()) <= 0;
    }

    public BigDecimal calculateOverdraftUsage(UUID accountId, BigDecimal amount) {

        var account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        BigDecimal available = account.getBalance().getAvailable();

        if (amount.compareTo(available) <= 0) {
            return BigDecimal.ZERO;
        }

        return amount.subtract(available);
    }

    public BigDecimal calculateInterest(BigDecimal overdraftUsed, BigDecimal dailyRate) {
        return overdraftUsed.multiply(dailyRate);
    }
}