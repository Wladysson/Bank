package com.bank.account.domain.repository;

import com.bank.account.domain.model.Account;

import java.util.Optional;
import java.util.UUID;

public interface AccountRepository {

    Account save(Account account);

    Optional<Account> findById(UUID accountId);

    Optional<Account> findByAccountNumber(String accountNumber);

    boolean existsByAccountNumber(String accountNumber);

    void deleteById(UUID accountId);
}