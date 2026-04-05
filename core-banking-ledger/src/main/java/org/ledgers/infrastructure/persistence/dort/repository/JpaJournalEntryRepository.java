package com.bank.ledger.infrastructure.persistence.repository;

import jakarta.enterprise.context.ApplicationScoped;
import com.bank.ledger.domain.model.JournalEntry;
import com.bank.ledger.domain.repository.JournalEntryRepository;

import java.util.*;

@ApplicationScoped
public class JpaJournalEntryRepository implements JournalEntryRepository {

    private final Map<UUID, JournalEntry> storage = new HashMap<>(); // temporário in-memory e depois trocar por JPA/Hibernate

    @Override
    public void save(JournalEntry journalEntry) {
        storage.put(journalEntry.getId(), journalEntry);
    }

    @Override
    public Optional<JournalEntry> findById(UUID journalEntryId) {
        return Optional.ofNullable(storage.get(journalEntryId));
    }

    @Override
    public Iterable<JournalEntry> findAll() {
        return storage.values();
    }
}