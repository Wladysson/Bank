package com.bank.payments.application.usecase.pix;

import com.bank.payments.application.service.PixKeyValidationService;
import com.bank.payments.domain.model.PixKey;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ValidatePixKeyUseCase {

    private final PixKeyValidationService pixKeyValidationService;

    @Inject
    public ValidatePixKeyUseCase(PixKeyValidationService pixKeyValidationService) {
        this.pixKeyValidationService = pixKeyValidationService;
    }

    public PixKey execute(String key) {
        return pixKeyValidationService.validate(key);
    }
}