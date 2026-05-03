package com.bank.payments.application.service;

import com.bank.payments.domain.model.PixKey;
import com.bank.payments.infrastructure.integration.pix.PixKeyService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class PixKeyValidationService {

    private final PixKeyService pixKeyService;

    @Inject
    public PixKeyValidationService(PixKeyService pixKeyService) {
        this.pixKeyService = pixKeyService;
    }

    public PixKey validate(String keyValue) {
        return pixKeyService.validateAndResolve(keyValue);
    }
}