package com.bank.transactions.infrastructure.integration.pix;

import com.bank.transactions.application.service.PixTransactionOrchestratorService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class PixWebhookReceiver {

    private final PixTransactionOrchestratorService pixTransactionOrchestratorService;

    @Inject
    public PixWebhookReceiver(
            PixTransactionOrchestratorService pixTransactionOrchestratorService
    ) {
        this.pixTransactionOrchestratorService =
                pixTransactionOrchestratorService;
    }

    @Transactional
    public void handleTransactionConfirmed(String endToEndId) {

        pixTransactionOrchestratorService
                .confirmSettlement(endToEndId);
    }

    @Transactional
    public void handleTransactionRefunded(
            String endToEndId,
            String reason
    ) {

        pixTransactionOrchestratorService
                .processRefund(
                        endToEndId,
                        reason
                );
    }

    @Transactional
    public void handleTransactionFailed(
            String endToEndId,
            String reason
    ) {

        pixTransactionOrchestratorService
                .processFailure(
                        endToEndId,
                        reason
                );
    }

    public PixTransactionStatus syncStatus(String endToEndId) {

        return pixTransactionOrchestratorService
                .syncStatus(endToEndId);
    }
}