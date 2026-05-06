package com.bank.transactions.application.usecase.pix;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class GeneratePixQrCodeUseCase {

    private final PixQrCodeService pixQrCodeService;

    @Inject
    public GeneratePixQrCodeUseCase(PixQrCodeService pixQrCodeService) {
        this.pixQrCodeService = pixQrCodeService;
    }

    public PixQrCodeResponse execute(PixQrCodeRequest request) {

        validate(request);

        // 🧾 Geração do QR Code Pix (estático ou dinâmico)
        PixQrCode qrCode = pixQrCodeService.generate(
                request.pixKey(),
                request.amount(),
                request.description()
        );

        return PixQrCodeResponse.from(qrCode);
    }

    private void validate(PixQrCodeRequest request) {

        if (request == null) {
            throw new IllegalArgumentException("A solicitação de QR Code Pix não pode ser nula.");
        }

        if (request.pixKey() == null || request.pixKey().isBlank()) {
            throw new IllegalArgumentException("É necessário informar uma chave PIX.");
        }

        if (request.amount() != null && request.amount().signum() <= 0) {
            throw new IllegalArgumentException("O valor do QR Code deve ser maior que zero.");
        }
    }
}