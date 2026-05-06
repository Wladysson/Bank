package com.bank.transactions.application.usecase.pix;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ValidatePixKeyUseCase {

    private final PixKeyService pixKeyService;

    @Inject
    public ValidatePixKeyUseCase(PixKeyService pixKeyService) {
        this.pixKeyService = pixKeyService;
    }

    public PixKey execute(String key) {

        validate(key);

        // 🔍 Validação + enriquecimento da chave (consulta externa, DICT, etc.)
        return pixKeyService.validate(key);
    }

    private void validate(String key) {
        if (key == null || key.isBlank()) {
            throw new IllegalArgumentException("A chave PIX não pode ser nula ou vazia.");
        }
    }
}