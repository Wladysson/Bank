package com.bank.payments.application.usecase.qrcode;

import java.math.BigDecimal;
import java.util.UUID;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProcessQRCodePaymentUseCase {

    public PaymentResult execute(String paymentId, BigDecimal amount) {

        if (paymentId == null || paymentId.isBlank()) {
            throw new IllegalArgumentException("paymentId não pode ser vazio");
        }

        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("amount inválido");
        }

        // Simulação de processamento de pagamento via QR Code
        PaymentResult result = new PaymentResult();
        result.setPaymentId(paymentId);
        result.setTransactionId(UUID.randomUUID().toString());
        result.setStatus("PROCESSED");
        result.setAmount(amount);

        return result;
    }

    // DTO simples de retorno
    public static class PaymentResult {

        private String paymentId;
        private String transactionId;
        private String status;
        private BigDecimal amount;

        public String getPaymentId() {
            return paymentId;
        }

        public void setPaymentId(String paymentId) {
            this.paymentId = paymentId;
        }

        public String getTransactionId() {
            return transactionId;
        }

        public void setTransactionId(String transactionId) {
            this.transactionId = transactionId;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public BigDecimal getAmount() {
            return amount;
        }

        public void setAmount(BigDecimal amount) {
            this.amount = amount;
        }
    }
}