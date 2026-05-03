package com.bank.payments.infrastructure.integration.pix;

import com.bank.payments.application.dto.request.PixPaymentRequest;
import com.bank.payments.application.dto.request.PixRefundRequest;
import com.bank.payments.application.dto.response.PixPaymentResponse;
import com.bank.payments.application.dto.response.PixQRCodeResponse;
import com.bank.payments.domain.model.PixKey;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PixClientImpl implements PixClient {

    @Override
    public PixPaymentResponse createPayment(PixPaymentRequest request) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public PixPaymentResponse confirmPayment(String transactionId) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public PixPaymentResponse refundPayment(PixRefundRequest request) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public PixPaymentResponse getPaymentStatus(String transactionId) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public PixQRCodeResponse generateQrCode(String transactionId) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public PixKey resolvePixKey(String key) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public boolean validatePixKey(String key) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}