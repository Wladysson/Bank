package com.bank.account.infrastructure.persistence.repository;

import com.bank.account.domain.model.AccountLimit;
import com.bank.account.domain.repository.AccountLimitRepository;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class JpaAccountLimitRepository implements AccountLimitRepository {

    @Override
    public AccountLimit save(UUID accountId, AccountLimit limit) {
        return limit;
    }

    @Override
    public Optional<AccountLimit> findByAccountId(UUID accountId) {
        return Optional.empty();
    }

    @Override
    public void deleteByAccountId(UUID accountId) {
    }
}