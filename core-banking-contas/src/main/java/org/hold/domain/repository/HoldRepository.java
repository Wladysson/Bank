package com.bank.account.domain.repository;

import com.bank.account.domain.model.HoldBalance;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface HoldRepository {

    HoldBalance save(UUID accountId, HoldBalance hold);

    Optional<HoldBalance> findById(UUID holdId);

    List<HoldBalance> findActiveByAccountId(UUID accountId);

    void delete(UUID holdId);
}