package com.bank.ledger.domain.service;

import com.bank.ledger.domain.model.JournalEntry;
import com.bank.ledger.domain.model.LedgerEntry;
import com.bank.ledger.domain.model.EntryType;

import java.util.List;

public class DoubleEntryValidator {

    public void validate(JournalEntry journalEntry) {

        List<LedgerEntry> entries = journalEntry.getEntries();

        if (entries == null || entries.isEmpty()) {
            throw new IllegalArgumentException("O lançamento no diário deve conter pelo menos uma entrada!");
        }

        long totalDebits = 0L;
        long totalCredits = 0L;

        for (LedgerEntry entry : entries) {

            if (entry.getAmount() <= 0) {
                throw new IllegalArgumentException("O valor da entrada deve ser positivo!!!");
            }

            if (entry.getType() == EntryType.DEBIT) {
                totalDebits += entry.getAmount();
            } else if (entry.getType() == EntryType.CREDIT) {
                totalCredits += entry.getAmount();
            } else {
                throw new IllegalArgumentException("Tipo de entrada inválido!");
            }
        }

        if (totalDebits != totalCredits) {
            throw new IllegalStateException(
                    "A validação de dupla entrada falhou: os débitos e créditos não são iguais!!!"
            );
        }
    }
}

