package com.bank.payments.infrastructure.integration.pix;

import com.bank.payments.application.dto.response.PixQRCodeResponse;
import com.bank.payments.domain.model.PixPayment;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Base64;

@ApplicationScoped
public class PixQrCodeGenerator {

    public PixQRCodeResponse generate(PixPayment payment) {

        String payload = buildPayload(payment);
        String base64Image = Base64.getEncoder()
                .encodeToString(payload.getBytes());

        return new PixQRCodeResponse(
                payment.getTxId(),
                payload,
                base64Image,
                payment.getReceiverKey().getValue(),
                payment.getAmount().toString(),
                "BR"
        );
    }

    private String buildPayload(PixPayment payment) {
        return "000201" +
                "26580014BR.GOV.BCB.PIX" +
                "01" + payment.getReceiverKey().getValue() +
                "52040000" +
                "5303986" +
                "54" + payment.getAmount() +
                "5802BR" +
                "59RECEBEDOR" +
                "60SAO PAULO" +
                "62" + payment.getTxId();
    }
}