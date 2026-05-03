package com.bank.payments.infrastructure.integration.pix;

import com.bank.payments.application.service.PixOrchestratorService;
import com.bank.payments.application.dto.response.PixPaymentResponse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.UUID;

@ApplicationScoped
public class PixWebhookHandler {

    private final PixOrchestratorService pixOrchestratorService;

    @Inject
    public PixWebhookHandler(PixOrchestratorService pixOrchestratorService) {
        this.pixOrchestratorService = pixOrchestratorService;
    }

    @Transactional
    public void handlePaymentConfirmed(String transactionId) {
        UUID txId = UUID.fromString(transactionId);
        pixOrchestratorService.confirmPayment(txId);
    }

    @Transactional
    public void handlePaymentRefunded(String transactionId, String reason) {
        // Implementação futura: processar evento de estorno vindo do PSP
    }

    public PixPaymentResponse handleStatusSync(String transactionId) {
        UUID txId = UUID.fromString(transactionId);
        return pixOrchestratorService.getStatus(txId);
    }
}
