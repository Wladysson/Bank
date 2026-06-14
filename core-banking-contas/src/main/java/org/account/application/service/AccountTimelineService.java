package com.bank.account.application.service;

import com.bank.account.domain.model.AccountId;
import com.bank.account.domain.model.AccountSnapshot;
import com.bank.account.domain.repository.AccountSnapshotRepository;

import java.util.List;

public class AccountTimelineService {

    private final AccountSnapshotRepository snapshotRepository;

    public AccountTimelineService(AccountSnapshotRepository snapshotRepository) {
        this.snapshotRepository = snapshotRepository; // injeta repositório de snapshots
    }

    public List<AccountSnapshot> getHistory(AccountId accountId) {
        return snapshotRepository.findHistoryByAccountId(accountId); // retorna histórico completo
    }

    public AccountSnapshot getCurrent(AccountId accountId) {
        return snapshotRepository.findByAccountId(accountId)
                .orElseThrow(() -> new IllegalArgumentException("Snapshot not found")); // snapshot atual
    }
}