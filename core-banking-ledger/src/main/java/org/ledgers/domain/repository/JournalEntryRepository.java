package com.bank.ledger.domain.repository;

import com.bank.ledger.domain.model.JournalEntry;
import java.util.Optional;
import java.util.UUID;

public interface JournalEntryRepository {

    // salva um journal entry no ledger
    void save(JournalEntry journalEntry);

    // busca por id
    Optional<JournalEntry> findById(UUID journalEntryId);

    // busca todos os lançamentos
    Iterable<JournalEntry> findAll();

}