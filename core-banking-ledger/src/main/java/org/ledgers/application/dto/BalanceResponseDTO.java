package com.bank.ledger.application.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BalanceResponseDTO {

    private String accountNumber;
    private BigDecimal balance;
    private LocalDate referenceDate;

    public BalanceResponseDTO(String accountNumber, BigDecimal balance, LocalDate referenceDate) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.referenceDate = referenceDate;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public LocalDate getReferenceDate() {
        return referenceDate;
    }
}