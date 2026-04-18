package com.bank.payments.infrastructure.config;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.bank.payments.infrastructure.integration.ledger.LedgerClient;

@ApplicationScoped
public class RestClientConfig {

    @RestClient
    LedgerClient ledgerClient;

    public LedgerClient ledger() {
        return ledgerClient;
    }
}