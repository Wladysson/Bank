package com.bank.account.infrastructure.persistence.repository;

import com.bank.account.domain.model.HoldBalance;
import com.bank.account.domain.repository.HoldRepository;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class JpaHoldRepository implements HoldRepository {

    @Override
    public HoldBalance save(UUID accountId, HoldBalance hold) {
        return hold;
    }

    @Override
    public Optional<HoldBalance> findById(UUID holdId) {
        return Optional.empty();
    }

    @Override
    public List<HoldBalance> findActiveByAccountId(UUID accountId) {
        return List.of();
    }

    @Override
    public void delete(UUID holdId) {
    }
}