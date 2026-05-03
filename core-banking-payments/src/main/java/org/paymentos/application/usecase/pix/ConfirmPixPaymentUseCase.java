package com.bank.payments.application.usecase.pix;

import com.bank.payments.application.dto.response.PixPaymentResponse;
import com.bank.payments.application.service.PixOrchestratorService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.UUID;

@ApplicationScoped
public class ConfirmPixPaymentUseCase {

    private final PixOrchestratorService pixOrchestratorService;

    @Inject
    public ConfirmPixPaymentUseCase(PixOrchestratorService pixOrchestratorService) {
        this.pixOrchestratorService = pixOrchestratorService;
    }

    @Transactional
    public PixPaymentResponse execute(String transactionId) {
        return pixOrchestratorService.confirmPayment(UUID.fromString(transactionId));    }
}
