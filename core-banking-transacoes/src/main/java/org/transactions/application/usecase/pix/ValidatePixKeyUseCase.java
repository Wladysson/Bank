package com.bank.transactions.application.usecase.pix;

import com.bank.transactions.application.service.PixKeyService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

// Use case responsável por validar chave PIX
@ApplicationScoped
public class ValidatePixKeyUseCase {

    @Inject
    PixKeyService pixKeyService;

    // Valida existência e integridade da chave PIX
    public boolean execute(String pixKey) {
        return pixKeyService.validate(pixKey);
    }
}