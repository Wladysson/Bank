package org.bank.ledger.domain.repository;

import org.bank.ledger.domain.model.LedgerEntry;
import java.util.Optional;
import java.util.UUID;

public interface LedgerEntryRepository {

    void save(LedgerEntry ledgerEntry);

    Optional<LedgerEntry> findById(UUID id);

    Iterable<LedgerEntry> findAll();
}