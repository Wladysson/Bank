package com.bank.payments.application.dto.response;

public record PixQRCodeResponse(
        String txId,
        String qrCode,
        String qrCodeBase64,
        String copyPasteCode,
        String expirationDate,
        String status
) {

    public static PixQRCodeResponse of(
            String txId,
            String qrCode,
            String qrCodeBase64,
            String copyPasteCode,
            String expirationDate,
            String status
    ) {
        return new PixQRCodeResponse(
                txId,
                qrCode,
                qrCodeBase64,
                copyPasteCode,
                expirationDate,
                status
        );
    }
}
