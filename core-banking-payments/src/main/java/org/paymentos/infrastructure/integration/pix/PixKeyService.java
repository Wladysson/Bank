package com.bank.payments.infrastructure.integration.pix;

import com.bank.payments.domain.model.PixKey;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class PixKeyService {

    private final PixClient pixClient;

    @Inject
    public PixKeyService(PixClient pixClient) {
        this.pixClient = pixClient;
    }

    public PixKey findKey(String key) {
        return pixClient.resolvePixKey(key);
    }

    public boolean exists(String key) {
        return pixClient.validatePixKey(key);
    }

    public PixKey validateAndResolve(String key) {
        if (!exists(key)) {
            throw new IllegalArgumentException("Invalid or non-existent PIX key: " + key);
        }
        return findKey(key);
    }
}