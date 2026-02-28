package com.bank.ledger.application.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class JournalRequestDTO {

    @NotNull
    private LocalDateTime transactionDate;

    @NotEmpty
    private String description;

    @NotEmpty
    private List<EntryDTO> entries;

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<EntryDTO> getEntries() {
        return entries;
    }

    public void setEntries(List<EntryDTO> entries) {
        this.entries = entries;
    }

    public static class EntryDTO {

        @NotEmpty
        private String accountNumber;

        @NotNull
        @Positive
        private BigDecimal amount;

        @NotNull
        private Boolean debit;

        public String getAccountNumber() {
            return accountNumber;
        }

        public void setAccountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
        }

        public BigDecimal getAmount() {
            return amount;
        }

        public void setAmount(BigDecimal amount) {
            this.amount = amount;
        }

        public Boolean getDebit() {
            return debit;
        }

        public void setDebit(Boolean debit) {
            this.debit = debit;
        }
    }
}

