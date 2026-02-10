package com.bank.account.domain.model;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Statement {

    private final UUID accountId;
    private final List<Transaction> transactions;

    public Statement(UUID accountId) {
        this.accountId = accountId;
        this.transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }

    public List<Transaction> getTransactions() {
        return Collections.unmodifiableList(transactions);
    }

    public UUID getAccountId() {
        return accountId;
    }

    public static class Transaction {

        private final UUID transactionId;
        private final TransactionType type;
        private final BigDecimal amount;
        private final BigDecimal balanceAfter;
        private final Instant timestamp;
        private final String description;

        public Transaction(
                TransactionType type,
                BigDecimal amount,
                BigDecimal balanceAfter,
                String description
        ) {
            this.transactionId = UUID.randomUUID();
            this.type = type;
            this.amount = amount;
            this.balanceAfter = balanceAfter;
            this.timestamp = Instant.now();
            this.description = description;
        }

        public UUID getTransactionId() { return transactionId; }
        public TransactionType getType() { return type; }
        public BigDecimal getAmount() { return amount; }
        public BigDecimal getBalanceAfter() { return balanceAfter; }
        public Instant getTimestamp() { return timestamp; }
        public String getDescription() { return description; }
    }

    public enum TransactionType {
        DEPOSIT,
        WITHDRAW,
        TRANSFER,
        HOLD,
        HOLD_RELEASE,
        OVERDRAFT_USE,
        OVERDRAFT_REPAY
    }
}

