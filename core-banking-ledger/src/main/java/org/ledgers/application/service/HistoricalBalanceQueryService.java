package com.bank.ledger.application.service;

import com.bank.ledger.domain.model.LedgerEntry;
import com.bank.ledger.domain.repository.LedgerEntryRepository;
import com.bank.ledger.domain.service.BalanceReconstructionService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class HistoricalBalanceQueryService {

    private final LedgerEntryRepository ledgerRepository;
    private final BalanceReconstructionService balanceService;

    public HistoricalBalanceQueryService(
            LedgerEntryRepository ledgerRepository,
            BalanceReconstructionService balanceService
    ) {
        this.ledgerRepository = ledgerRepository;
        this.balanceService = balanceService;
    }

    public BigDecimal getBalance(String accountNumber, LocalDate referenceDate) {

        List<LedgerEntry> entries =
                ledgerRepository.findByAccountNumberUntilDate(accountNumber, referenceDate);

        return balanceService.reconstructBalance(entries);
    }
}

