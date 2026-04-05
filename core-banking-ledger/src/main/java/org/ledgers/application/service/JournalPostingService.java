package com.bank.ledger.application.service;

import com.bank.ledger.application.command.PostJournalCommand;
import com.bank.ledger.domain.model.JournalEntry;
import com.bank.ledger.domain.model.LedgerEntry;
import com.bank.ledger.domain.service.DoubleEntryValidator;
import com.bank.ledger.domain.repository.JournalEntryRepository;
import com.bank.ledger.domain.model.EntryType;
import java.util.List;

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

        List<PostJournalCommand.EntryCommand> entries = command.getEntries();

        JournalEntry journalEntry = new JournalEntry(
                command.getJournalId(),
                command.getTransactionDate(),
                command.getDescription(),
                command.getEntries().stream()
                        .map((PostJournalCommand.EntryCommand e) -> new LedgerEntry(
                                UUID.randomUUID(),
                                UUID.fromString(e.getAccountNumber()),
                                e.getAmount().longValue(),
                                e.isDebit() ? EntryType.DEBIT : EntryType.CREDIT,
                                java.time.Instant.now()
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