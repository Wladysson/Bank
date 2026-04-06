package com.bank.ledger.application.service;

import com.bank.ledger.application.command.PostJournalCommand;
import com.bank.ledger.domain.model.JournalEntry;
import com.bank.ledger.domain.model.LedgerEntry;
import com.bank.ledger.domain.service.DoubleEntryValidator;
import com.bank.ledger.domain.repository.JournalEntryRepository;
import com.bank.ledger.domain.model.EntryType;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import java.time.Instant;

import java.util.UUID;
import java.util.stream.Collectors;

@ApplicationScoped
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

        List<LedgerEntry> ledgerEntries = command.getEntries().stream()
                .map(e -> new LedgerEntry(
                        UUID.randomUUID(),
                        UUID.fromString(e.getAccountNumber()),
                        e.getAmount().longValue(),
                        e.isDebit() ? EntryType.DEBIT : EntryType.CREDIT,
                        Instant.now()
                ))
                .collect(Collectors.toList());

        JournalEntry journalEntry = new JournalEntry(
                command.getJournalId(),
                command.getTransactionDate(),
                command.getDescription(),
                ledgerEntries
        );

        // valida regra contábil
        doubleEntryValidator.validate(journalEntry);

        // salva no banco
        journalRepository.save(journalEntry);

        return journalEntry.getId();
    }

    public void postEntry(PostJournalCommand command) {
        // aqui você implementa a lógica
        // por enquanto pode deixar simples só pra subir

        System.out.println("Journal recebido: " + command);
    }
}