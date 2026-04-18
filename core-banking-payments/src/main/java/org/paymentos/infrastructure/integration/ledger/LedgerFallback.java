package com.bank.payments.infrastructure.integration.ledger;

import com.bank.payments.application.dto.internal.LedgerPostingRequest;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LedgerFallback implements LedgerClient {

    @Override
    public void postTransaction(LedgerPostingRequest request) {
        // fallback simples (log depois melhora)
        System.err.println("Ledger indisponivel - fallback acionado");
    }
}