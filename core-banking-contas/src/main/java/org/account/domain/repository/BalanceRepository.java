package com.bank.account.domain.repository;

import com.bank.account.domain.model.Balance;

import java.util.Optional;
import java.util.UUID;

public interface BalanceRepository {

    Balance save(UUID accountId, Balance balance);

    Optional<Balance> findByAccountId(UUID accountId);

    void deleteByAccountId(UUID accountId);
}