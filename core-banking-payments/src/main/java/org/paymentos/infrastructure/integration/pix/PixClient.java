package com.bank.payments.infrastructure.integration.pix;

import com.bank.payments.application.dto.request.PixPaymentRequest;
import com.bank.payments.application.dto.request.PixRefundRequest;
import com.bank.payments.application.dto.response.PixPaymentResponse;
import com.bank.payments.application.dto.response.PixQRCodeResponse;
import com.bank.payments.domain.model.PixKey;

public interface PixClient {

    PixPaymentResponse createPayment(PixPaymentRequest request);

    PixPaymentResponse confirmPayment(String transactionId);

    PixPaymentResponse refundPayment(PixRefundRequest request);

    PixPaymentResponse getPaymentStatus(String transactionId);

    PixQRCodeResponse generateQrCode(String transactionId);

    PixKey resolvePixKey(String key);

    boolean validatePixKey(String key);
}