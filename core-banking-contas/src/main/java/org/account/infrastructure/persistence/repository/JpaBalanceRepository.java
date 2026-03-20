package com.bank.account.infrastructure.persistence.repository;

import com.bank.account.domain.model.Balance;
import com.bank.account.domain.repository.BalanceRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class JpaBalanceRepository implements BalanceRepository {

    @Override
    public Balance save(UUID accountId, Balance balance) {
        return balance;
    }

    @Override
    public Optional<Balance> findByAccountId(UUID accountId) {
        return Optional.empty();
    }

    @Override
    public void deleteByAccountId(UUID accountId) {
    }
}