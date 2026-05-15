package com.bank.transactions.infrastructure.integration.pix;

import com.seubanco.transactions.domain.gateway.pix.PixQrCodeGateway;
import jakarta.enterprise.context.ApplicationScoped;

// Implementação do gateway de QR Code PIX
@ApplicationScoped
public class PixQrCodeGatewayImpl implements PixQrCodeGateway {

    // Gera QR Code PIX
    @Override
    public String generateQrCode(
            String transactionId,
            String payerName,
            String payerKey,
            String amount
    ) {

        return "PIX-QRCODE-" + transactionId;
    }

    // Consulta QR Code gerado
    @Override
    public String getQrCodeByTransactionId(
            String transactionId
    ) {

        return "PIX-QRCODE-" + transactionId;
    }
}