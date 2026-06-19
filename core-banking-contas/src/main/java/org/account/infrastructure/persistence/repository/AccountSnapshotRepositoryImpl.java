package com.bank.account.infrastructure.persistence.repository;

import com.bank.account.domain.model.AccountId;
import com.bank.account.domain.model.AccountSnapshot;
import com.bank.account.domain.repository.AccountSnapshotRepository;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class AccountSnapshotRepositoryImpl
        implements AccountSnapshotRepository {

    @Override
    public AccountSnapshot save(AccountSnapshot snapshot) {
        return snapshot;
    }

    @Override
    public Optional<AccountSnapshot> findByAccountId(
            AccountId accountId
    ) {
        return Optional.empty();
    }

    @Override
    public List<AccountSnapshot> findHistoryByAccountId(
            AccountId accountId
    ) {
        return List.of();
    }
}