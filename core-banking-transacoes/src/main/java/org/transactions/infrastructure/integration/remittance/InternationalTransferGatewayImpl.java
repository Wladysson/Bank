package com.bank.transactions.infrastructure.integration.remittance;

import com.bank.transactions.domain.gateway.international.InternationalTransferGateway;
import com.bank.transactions.domain.model.international.InternationalTransfer;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.HashMap;
import java.util.Map;

// Implementação do gateway de transferências internacionais
@ApplicationScoped
public class InternationalTransferGatewayImpl
        implements InternationalTransferGateway {

    @RestClient
    InternationalRemittanceApiClient remittanceApiClient;

    @Override
    public InternationalTransfer execute(
            InternationalTransfer internationalTransfer
    ) {

        Map<String, Object> payload = new HashMap<>();

        payload.put(
                "transactionId",
                internationalTransfer.getTransactionId().getValue()
        );

        // ⚠️ aqui você precisa adaptar ao seu DOMAIN real
        payload.put(
                "amount",
                internationalTransfer.getAmount().getAmount()
        );

        remittanceApiClient.executeTransfer(payload);

        return internationalTransfer;
    }

    @Override
    public InternationalTransfer findByTransactionId(String transactionId) {
        remittanceApiClient.getTransfer(transactionId);
        return new InternationalTransfer();
    }

    @Override
    public void cancel(String transactionId) {
        remittanceApiClient.cancelTransfer(transactionId);
    }
}