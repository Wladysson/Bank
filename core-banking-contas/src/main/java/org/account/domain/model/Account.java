package com.bank.account.domain.model;

import java.math.BigDecimal;
import java.util.*;

public class Account {

    private final UUID accountId;
    private final String accountNumber;
    private AccountStatus status;
    private final AccountType type;

    private final List<AccountHolder> holders;
    private final Balance balance;
    private final List<HoldBalance> holds;

    private OverdraftLimit overdraftLimit;
    private AccountLimit accountLimit;

    private Account(UUID id, String accountNumber, AccountType type) {
        this.accountId = id;
        this.accountNumber = accountNumber;
        this.type = type;
        this.status = AccountStatus.ACTIVE;
    }

    public static Account open(UUID id, String accountNumber, String type) {
        return new Account(
                id,
                accountNumber,
                AccountType.valueOf(type.toUpperCase())
        );
    }

    public void block(String reason) {
        if (status == AccountStatus.CLOSED) {
            throw new IllegalStateException("Conta já encerrada");
        }
        this.status = AccountStatus.CLOSED;
    }

    //Domain in futuro pachta

    public void close() {
        if (status == AccountStatus.CLOSED) {
            throw new IllegalStateException("Conta já encerrada");
        }
        this.status = AccountStatus.CLOSED;
    }

    public void deposit(BigDecimal amount) {
        balance.deposit(amount);
    }

    public void withdraw(BigDecimal amount) {
        balance.withdraw(amount);
    }

    public HoldBalance reserveAmount(BigDecimal amount) {
        balance.reserve(amount);
        HoldBalance hold = new HoldBalance(amount);
        holds.add(hold);
        return hold;
    }

    public void releaseHold(UUID holdId) {
        HoldBalance hold = holds.stream()
                .filter(h -> h.getHoldId().equals(holdId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Hold não encontrado"));

        hold.release();
        balance.release(hold.getAmount());
    }

    public UUID getAccountId() { return accountId; }
    public String getAccountNumber() { return accountNumber; }
    public AccountStatus getStatus() { return status; }
    public AccountType getType() { return type; }
    public Balance getBalance() { return balance; }
}