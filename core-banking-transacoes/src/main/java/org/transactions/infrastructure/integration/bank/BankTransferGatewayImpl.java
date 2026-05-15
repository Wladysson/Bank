package com.bank.transactions.infrastructure.integration.bank;

import com.bank.transactions.domain.gateway.bank.BankTransferGateway;
import com.bank.transactions.domain.model.bank.BankTransfer;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.HashMap;
import java.util.Map;

// Implementação do gateway bancário
@ApplicationScoped
public class BankTransferGatewayImpl
        implements BankTransferGateway {

    @RestClient
    TedDocApiClient tedDocApiClient;

    // Executa transferência bancária
    @Override
    public BankTransfer execute(
            BankTransfer bankTransfer
    ) {

        Map<String, Object> payload = new HashMap<>();

        payload.put(
                "transactionId",
                bankTransfer.getTransactionId().getValue()
        );

        payload.put(
                "amount",
                bankTransfer.getAmount().getAmount()
        );

        payload.put(
                "destinationBank",
                bankTransfer.getDestinationBank()
        );

        tedDocApiClient.executeTransfer(payload);

        return bankTransfer;
    }

    // Consulta transferência bancária
    @Override
    public BankTransfer findByTransactionId(
            String transactionId
    ) {

        tedDocApiClient.getTransfer(transactionId);

        return new BankTransfer();
    }

    // Verifica disponibilidade operacional
    @Override
    public boolean isAvailable() {

        Map<String, Object> response =
                tedDocApiClient.getAvailability();

        return Boolean.TRUE.equals(
                response.get("available")
        );
    }

    // Cancela transferência bancária
    @Override
    public void cancel(String transactionId) {
        tedDocApiClient.cancelTransfer(transactionId);
    }
}