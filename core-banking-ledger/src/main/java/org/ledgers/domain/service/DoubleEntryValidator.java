package com.bank.ledger.domain.service;

import org.bank.ledger.domain.model.JournalEntry;
import com.bank.ledger.domain.model.LedgerEntry;

import java.math.BigDecimal;
import java.util.List;

public class DoubleEntryValidator {

    public void validate(JournalEntry journalEntry) {

        List<LedgerEntry> entries = journalEntry.getEntries();

        if (entries == null || entries.isEmpty()) {
            throw new IllegalArgumentException("O lançamento no diário deve conter pelo menos uma entrada!");
        }

        BigDecimal totalDebits = BigDecimal.ZERO;
        BigDecimal totalCredits = BigDecimal.ZERO;

        for (LedgerEntry entry : entries) {

            if (entry.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
                throw new IllegalArgumentException("O valor da entrada deve ser positivo!!!");
            }

            if (entry.isDebit()) {
                totalDebits = totalDebits.add(entry.getAmount());
            } else {
                totalCredits = totalCredits.add(entry.getAmount());
            }
        }

        if (totalDebits.compareTo(totalCredits) != 0) {
            throw new IllegalStateException(
                    "A validaçao de dupla entrada falhou: os debitos e creditos nao sao iguais!!!"
            );
        }
    }
}

