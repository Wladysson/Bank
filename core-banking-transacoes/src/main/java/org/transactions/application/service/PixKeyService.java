package com.bank.transactions.application.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class PixKeyService {

    private final PixKeyGateway pixKeyGateway;

    @Inject
    public PixKeyService(PixKeyGateway pixKeyGateway) {
        this.pixKeyGateway = pixKeyGateway;
    }

    public PixKey resolve(String keyValue) {

        validate(keyValue);

        //Consulta externa (DICT / provedor Pix)
        return pixKeyGateway.resolve(keyValue);
    }

    private void validate(String keyValue) {
        if (keyValue == null || keyValue.isBlank()) {
            throw new IllegalArgumentException("A chave PIX não pode ser nula ou vazia.");
        }
    }
}