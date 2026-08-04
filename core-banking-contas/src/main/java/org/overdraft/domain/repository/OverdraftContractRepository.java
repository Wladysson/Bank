package com.bank.account.overdraft.domain.repository;

import com.bank.account.overdraft.domain.model.OverdraftContract;

import java.util.List;
import java.util.Optional;

public interface OverdraftContractRepository {

    OverdraftContract save(
            OverdraftContract contract
    );

    Optional<OverdraftContract> findById(
            String contractId
    );

    Optional<OverdraftContract> findByAccountId(
            String accountId
    );

    List<OverdraftContract> findAllByAccountId(
            String accountId
    );

    Optional<OverdraftContract> findActiveByAccountId(
            String accountId
    );

    boolean existsByAccountId(
            String accountId
    );

    void delete(
            OverdraftContract contract
    );
}