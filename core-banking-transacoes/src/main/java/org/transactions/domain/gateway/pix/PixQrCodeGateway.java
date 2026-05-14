package com.bank.transactions.domain.gateway.pix;

// Gateway responsável pela geração de QR Codes PIX
public interface PixQrCodeGateway {

    // Gera QR Code PIX
    String generateQrCode(
            String transactionId,
            String payerName,
            String payerKey,
            String amount
    );

    // Consulta QR Code gerado
    String getQrCodeByTransactionId(String transactionId);
}