package com.bank.account.application.service;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.UUID;

@ApplicationScoped
public class DocumentGenerationService {

    public byte[] generateAccountStatement(UUID accountId) {

        // gerar PDF (ex: iText)
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public byte[] generateOwnershipDeclaration(UUID accountId) {

        throw new UnsupportedOperationException("Not implemented yet");
    }

    public byte[] generateIncomeReport(UUID accountId) {

        throw new UnsupportedOperationException("Not implemented yet");
    }
}