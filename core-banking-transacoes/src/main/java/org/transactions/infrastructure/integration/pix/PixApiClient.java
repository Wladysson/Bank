package com.bank.transactions.infrastructure.integration.pix;

import jakarta.enterprise.context.ApplicationScoped;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@ApplicationScoped
public class PixAPIClient {

    public PixExecutionResult execute(PixTransaction transaction) {

        /*
         * Aqui entra:
         * - REST Client
         * - WebClient
         * - chamada SPI/BACEN
         * - integração banco parceiro
         */

        return new PixExecutionResult(
                "E2E-" + UUID.randomUUID(),
                "COMPLETED",
                "PIX transaction executed successfully"
        );
    }

    public PixExecutionResult refund(PixTransaction transaction) {

        return new PixExecutionResult(
                "E2E-REFUND-" + UUID.randomUUID(),
                "COMPLETED",
                "PIX refund executed successfully"
        );
    }

    public PixExecutionResult getStatus(String endToEndId) {

        return new PixExecutionResult(
                endToEndId,
                "COMPLETED",
                "PIX transaction status retrieved successfully"
        );
    }

    public PixQrCode generateQrCode(
            String pixKey,
            BigDecimal amount,
            String description
    ) {

        return new PixQrCode(
                UUID.randomUUID().toString(),
                "00020126580014BR.GOV.BCB.PIX0114+5585999999995204000053039865405100.005802BR5920BANKTRANSACTION6009FORTALEZA62070503***6304ABCD",
                OffsetDateTime.now().plusMinutes(30)
        );
    }

    public PixKey resolvePixKey(String key) {

        return new PixKey(
                key,
                PixKeyType.RANDOM
        );
    }
}