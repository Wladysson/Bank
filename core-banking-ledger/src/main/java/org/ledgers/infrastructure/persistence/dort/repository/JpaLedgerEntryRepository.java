package com.bank.ledger.infrastructure.persistence.repository;

import jakarta.enterprise.context.ApplicationScoped;
import com.bank.ledger.domain.model.LedgerEntry;
import com.bank.ledger.domain.repository.LedgerEntryRepository;

import java.util.*;

@ApplicationScoped
public class JpaLedgerEntryRepository implements LedgerEntryRepository {

    private final Map<UUID, LedgerEntry> storage = new HashMap<>();

    @Override
    public void save(LedgerEntry ledgerEntry) {
        storage.put(ledgerEntry.getId(), ledgerEntry);
    }

    @Override
    public Optional<LedgerEntry> findById(UUID id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public Iterable<LedgerEntry> findAll() {
        return storage.values();
    }
}