package com.bank.transactions.application.usecase.pix;

import com.seubanco.transactions.application.dto.request.pix.GeneratePixQrCodeRequest;
import com.seubanco.transactions.application.dto.response.pix.PixQrCodeResponse;
import com.seubanco.transactions.application.service.PixTransactionService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

// Use case responsável pela geração de QR Code PIX
@ApplicationScoped
public class GeneratePixQrCodeUseCase {

    @Inject
    PixTransactionService pixTransactionService;

    // Gera QR Code estático ou dinâmico
    public PixQrCodeResponse execute(GeneratePixQrCodeRequest request) {
        return pixTransactionService.generateQrCode(request);
    }
}