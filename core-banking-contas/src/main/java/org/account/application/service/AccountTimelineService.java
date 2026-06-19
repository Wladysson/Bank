package com.bank.account.application.service;

import com.bank.account.domain.model.AccountId;
import com.bank.account.domain.model.AccountSnapshot;
import com.bank.account.domain.repository.AccountSnapshotRepository;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class AccountTimelineService {

    private final AccountSnapshotRepository snapshotRepository;

    public AccountTimelineService(
            AccountSnapshotRepository snapshotRepository
    ) {
        this.snapshotRepository = snapshotRepository;
    }

    public List<AccountSnapshot> getHistory(
            AccountId accountId
    ) {

        return snapshotRepository.findHistoryByAccountId(
                accountId
        );
    }

    public AccountSnapshot getCurrent(
            AccountId accountId
    ) {

        return snapshotRepository.findByAccountId(accountId)
                .orElseThrow(
                        () -> new IllegalArgumentException(
                                "Snapshot not found"
                        )
                );
    }
}