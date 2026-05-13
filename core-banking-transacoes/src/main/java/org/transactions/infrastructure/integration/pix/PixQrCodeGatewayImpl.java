package com.bank.transactions.infrastructure.integration.pix;

import jakarta.enterprise.context.ApplicationScoped;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Base64;
import java.util.UUID;

@ApplicationScoped
public class PixQrCodeGatewayImpl implements PixQrCodeGateway {

    public PixQrCode generate(
            PixKey pixKey,
            BigDecimal amount,
            String description
    ) {

        String payload = buildPayload(
                pixKey,
                amount,
                description
        );

        String qrCodeImage = Base64.getEncoder()
                .encodeToString(payload.getBytes());

        return new PixQrCode(
                UUID.randomUUID().toString(),
                payload,
                qrCodeImage,
                OffsetDateTime.now().plusMinutes(30)
        );
    }

    private String buildPayload(
            PixKey pixKey,
            BigDecimal amount,
            String description
    ) {

        return "000201"
                + "26580014BR.GOV.BCB.PIX"
                + "01" + pixKey.getValue()
                + "52040000"
                + "5303986"
                + "54" + amount
                + "5802BR"
                + "59BANK TRANSACTION"
                + "60FORTALEZA"
                + "62" + UUID.randomUUID()
                + description;
    }
}