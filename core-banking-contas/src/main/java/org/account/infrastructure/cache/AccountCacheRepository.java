package com.bank.account.infrastructure.cache;

import com.bank.account.domain.model.Account;
import com.bank.account.domain.model.AccountId;

import java.time.Duration;
import java.util.Optional;

public interface AccountCacheRepository {

    Optional<Account> findById(AccountId accountId); // recupera conta do cache

    void save(
            Account account,
            Duration ttl
    ); // armazena conta com tempo de expiração

    void evict(
            AccountId accountId
    ); // remove conta específica do cache

    void evictAll(); // remove todas as entradas do cache

    boolean exists(
            AccountId accountId
    ); // verifica se a conta está armazenada
}