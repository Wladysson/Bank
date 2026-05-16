package com.bank.transactions.infrastructure.messaging.consumer;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.Map;

// Consumer responsável pela liquidação PIX
@ApplicationScoped
public class PixSettlementConsumer {

    // Consome evento de liquidação PIX
    public void consume(
            Map<String, Object> payload
    ) {

        String transactionId =
                payload.get("transactionId").toString();

        String status =
                payload.get("status").toString();

        System.out.println(
                "Liquidação PIX recebida: "
                        + transactionId
                        + " - "
                        + status
        );
    }
}