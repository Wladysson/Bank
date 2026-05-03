package com.bank.payments.application.usecase.pix;

import com.bank.payments.application.dto.request.PixQRCodeRequest;
import com.bank.payments.application.dto.response.PixQRCodeResponse;
import com.bank.payments.application.service.PixOrchestratorService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class GeneratePixQRCodeUseCase {

    private final PixOrchestratorService pixOrchestratorService;

    @Inject
    public GeneratePixQRCodeUseCase(PixOrchestratorService pixOrchestratorService) {
        this.pixOrchestratorService = pixOrchestratorService;
    }

    public PixQRCodeResponse execute(PixQRCodeRequest request) {
        return pixOrchestratorService.generateQrCode(request);
    }
}