package com.bank.transactions.infrastructure.integration.pix;

import com.bank.transactions.domain.gateway.pix.PixGateway;
import com.bank.transactions.domain.model.pix.PixTransaction;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.HashMap;
import java.util.Map;

// Implementação do gateway PIX
@ApplicationScoped
public class PixGatewayImpl implements PixGateway {

    @RestClient
    PixApiClient pixApiClient;

    // Executa transação PIX
    @Override
    public PixTransaction execute(
            PixTransaction pixTransaction
    ) {

        Map<String, Object> payload = new HashMap<>();

        payload.put(
                "transactionId",
                pixTransaction.getTransactionId().getValue()
        );

        payload.put(
                "amount",
                pixTransaction.getAmount().getAmount()
        );

        pixApiClient.executeTransfer(payload);

        return pixTransaction;
    }

    // Busca transação PIX
    @Override
    public PixTransaction findByTransactionId(
            String transactionId
    ) {

        pixApiClient.getTransaction(transactionId);

        return new PixTransaction();
    }

    // Solicita estorno PIX
    @Override
    public void refund(String transactionId) {
        pixApiClient.refund(transactionId);
    }
}