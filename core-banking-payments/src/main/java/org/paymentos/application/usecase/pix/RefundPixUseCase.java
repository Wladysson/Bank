package com.bank.payments.application.usecase.pix;

import com.bank.payments.application.dto.request.PixRefundRequest;
import com.bank.payments.application.dto.response.PixPaymentResponse;
import com.bank.payments.application.service.PixOrchestratorService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class RefundPixUseCase {

    private final PixOrchestratorService pixOrchestratorService;

    @Inject
    public RefundPixUseCase(PixOrchestratorService pixOrchestratorService) {
        this.pixOrchestratorService = pixOrchestratorService;
    }

    @Transactional
    public PixPaymentResponse execute(PixRefundRequest request) {
        return pixOrchestratorService.refund(request);
    }
}