package com.bank.ledger.domain.service;

import com.bank.ledger.domain.model.LedgerEntry;

import java.math.BigDecimal;
import java.util.List;

public class BalanceReconstructionService {

    public BigDecimal reconstructBalance(List<LedgerEntry> entries) {

        BigDecimal balance = BigDecimal.ZERO;

        for (LedgerEntry entry : entries) {

            if (entry.isDebit()) {
                balance = balance.add(entry.getAmount());
            } else {
                balance = balance.subtract(entry.getAmount());
            }
        }

        return balance;
    }
}