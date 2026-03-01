package com.bank.ledger.application.command;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class PostJournalCommand {

    private final UUID journalId;
    private final LocalDateTime transactionDate;
    private final String description;
    private final List<EntryCommand> entries;

    public PostJournalCommand(
            UUID journalId,
            LocalDateTime transactionDate,
            String description,
            List<EntryCommand> entries
    ) {
        this.journalId = journalId;
        this.transactionDate = transactionDate;
        this.description = description;
        this.entries = entries;
    }

    public UUID getJournalId() {
        return journalId;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public String getDescription() {
        return description;
    }

    public List<EntryCommand> getEntries() {
        return entries;
    }

    // Classe interna e linha do lançamento do serviço
    public static class EntryCommand {

        private final String accountNumber;
        private final BigDecimal amount;
        private final boolean debit;

        public EntryCommand(String accountNumber, BigDecimal amount, boolean debit) {
            this.accountNumber = accountNumber;
            this.amount = amount;
            this.debit = debit;
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public BigDecimal getAmount() {
            return amount;
        }

        public boolean isDebit() {
            return debit;
        }
    }
}