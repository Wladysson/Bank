package com.bank.ledger.domain.service;

import com.bank.ledger.domain.model.LedgerEntry;

import java.math.BigDecimal;
import java.util.List;

public class BalanceReconstructionService {

    public BigDecimal reconstructBalance(List<LedgerEntry> entries) {

        BigDecimal totalDebits = BigDecimal.ZERO;
        BigDecimal totalCredits = BigDecimal.ZERO;

        for (LedgerEntry entry : entries) {

            if (entry.isDebit()) {
                totalDebits = totalDebits.add(BigDecimal.valueOf(entry.getAmount()));
            } else {
                totalCredits = totalCredits.add(BigDecimal.valueOf(entry.getAmount()));
            }
        }
        // O saldo é débito - crédito (ou o que sua regra contábil definir)
        return totalDebits.subtract(totalCredits);
    }
}