package com.bank.account.domain.repository;

import com.bank.account.domain.model.AccountLimit;

import java.util.Optional;
import java.util.UUID;

public interface AccountLimitRepository {

    AccountLimit save(UUID accountId, AccountLimit limit);

    Optional<AccountLimit> findByAccountId(UUID accountId);

    void deleteByAccountId(UUID accountId);
}