package com.bank.payments.application.service;

import com.bank.payments.application.dto.request.PixPaymentRequest;
import com.bank.payments.application.dto.request.PixQRCodeRequest;
import com.bank.payments.application.dto.request.PixRefundRequest;
import com.bank.payments.application.dto.response.PixPaymentResponse;
import com.bank.payments.application.dto.response.PixQRCodeResponse;
import com.bank.payments.domain.model.PixKey;
import com.bank.payments.domain.model.PixPayment;
import com.bank.payments.domain.model.PixTransactionType;
import com.bank.payments.domain.repository.PixRepository;
import com.bank.payments.infrastructure.integration.pix.PixAdapter;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.UUID;

@ApplicationScoped
public class PixOrchestratorService {

    private final PixRepository pixRepository;
    private final PixAdapter pixAdapter;
    private final PixKeyValidationService pixKeyValidationService;

    @Inject
    public PixOrchestratorService(
            PixRepository pixRepository,
            PixAdapter pixAdapter,
            PixKeyValidationService pixKeyValidationService) {
        this.pixRepository = pixRepository;
        this.pixAdapter = pixAdapter;
        this.pixKeyValidationService = pixKeyValidationService;
    }

    // CREATE PAYMENT
    public PixPaymentResponse createPayment(PixPaymentRequest request) {

        PixKey validatedKey = pixKeyValidationService.validate(request.pixKey());

        PixPayment payment = new PixPayment(
                request.transactionId(),
                validatedKey,
                request.amount(),
                request.description(),
                PixTransactionType.PAYMENT
        );

        payment.markAsProcessing();

        pixAdapter.createPayment(request);

        pixRepository.save(payment);

        return PixPaymentResponse.from(payment);
    }

    // CONFIRM PAYMENT
    public PixPaymentResponse confirmPayment(UUID transactionId) {

        PixPayment payment = pixRepository.findByTxId(transactionId.toString())
                .orElseThrow(() -> new IllegalArgumentException("Pagamento PIX não encontrado"));

        payment.confirm();

        pixRepository.update(payment);

        return PixPaymentResponse.from(payment);
    }

    // QR CODE
    public PixQRCodeResponse generateQrCode(PixQRCodeRequest request) {

        return pixAdapter.generateQrCode(request.beneficiaryPixKey());
    }

    // REFUND
    public PixPaymentResponse refund(PixRefundRequest request) {

        PixPayment payment = pixRepository.findById(request.originalPaymentId())
                .orElseThrow(() -> new IllegalArgumentException("Pagamento PIX não encontrado"));

        payment.refund();

        pixRepository.update(payment);

        return PixPaymentResponse.from(payment);
    }

    // STATUS
    public PixPaymentResponse getStatus(UUID transactionId) {

        PixPayment payment = pixRepository.findByTxId(transactionId.toString())
                .orElseThrow(() -> new IllegalArgumentException("Pagamento PIX não encontrado"));

        return PixPaymentResponse.from(payment);
    }
}