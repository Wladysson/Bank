package com.bank.account.application.service;

import com.bank.account.application.dto.StatementResponseDTO;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class StatementService {

    public List<StatementResponseDTO> getStatement(UUID accountId) {

        // aqui vamos chamar o ledger-service (Kafka)
        throw new UnsupportedOperationException("Integrate with Ledger Service");
    }
}