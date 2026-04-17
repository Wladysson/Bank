package com.bank.payments.application.usecase.boleto;

import com.bank.payments.application.dto.request.BoletoPaymentRequest;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ValidateBoletoUseCase {

    public void execute(BoletoPaymentRequest request) {

        if (request.getLinhaDigitavel() == null || request.getLinhaDigitavel().isBlank()) {
            throw new IllegalArgumentException("Linha digitável é obrigatória");
        }

        if (request.getPayerId() == null) {
            throw new IllegalArgumentException("PayerId é obrigatório");
        }

        // TODO: validação real FEBRABAN (checksum)
    }
}