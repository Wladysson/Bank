package com.bank.transactions.infrastructure.integration.pix;

import com.bank.transactions.domain.gateway.pix.PixKeyGateway;
import com.bank.transactions.domain.model.pix.PixKey;
import com.bank.transactions.domain.model.pix.PixKeyType;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;

@ApplicationScoped
public class PixKeyGatewayImpl implements PixKeyGateway {

    @Override
    public Optional<PixKey> findByValue(String value) {
        // TODO: implementar integração real de Pix Key API
        return Optional.empty();
    }

    @Override
    public boolean validateKey(String key, PixKeyType type) {
        // TODO: implementar validação real
        return true;
    }
}