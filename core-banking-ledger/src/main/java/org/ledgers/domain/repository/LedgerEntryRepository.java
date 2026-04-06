package com.bank.ledger.domain.repository;

import com.bank.ledger.domain.model.LedgerEntry;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.time.LocalDate;

public interface LedgerEntryRepository {

    // Método para buscar lançamentos de uma conta até uma data específica
    List<LedgerEntry> findByAccountNumberUntilDate(String accountNumber, LocalDate date);

    void save(LedgerEntry ledgerEntry);

    Optional<LedgerEntry> findById(UUID id);

    Iterable<LedgerEntry> findAll();
}