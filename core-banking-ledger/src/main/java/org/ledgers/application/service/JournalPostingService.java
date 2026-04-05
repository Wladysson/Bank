package com.bank.ledger.application.service;

import com.bank.ledger.application.command.PostJournalCommand;
import org.bank.ledger.domain.model.JournalEntry;
import com.bank.ledger.domain.model.LedgerEntry;
import com.bank.ledger.domain.service.DoubleEntryValidator;
import org.bank.ledger.domain.repository.JournalEntryRepository;

import java.util.UUID;
import java.util.stream.Collectors;

public class JournalPostingService {

    private final JournalEntryRepository journalRepository;
    private final DoubleEntryValidator doubleEntryValidator;

    public JournalPostingService(
            JournalEntryRepository journalRepository,
            DoubleEntryValidator doubleEntryValidator
    ) {
        this.journalRepository = journalRepository;
        this.doubleEntryValidator = doubleEntryValidator;
    }

    public UUID post(PostJournalCommand command) {

        JournalEntry journalEntry = new JournalEntry(
                command.getJournalId(),
                command.getTransactionDate(),
                command.getDescription(),
                command.getEntries().stream()
                        .map(e -> new LedgerEntry(
                                e.getAccountNumber(),
                                e.getAmount(),
                                e.isDebit()
                        ))
                        .collect(Collectors.toList())
        );

        // valida regra contábil
        doubleEntryValidator.validate(journalEntry);

        // salva no banco
        journalRepository.save(journalEntry);

        return journalEntry.getId();
    }
}