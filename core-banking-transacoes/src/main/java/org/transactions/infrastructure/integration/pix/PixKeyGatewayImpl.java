package com.bank.transactions.infrastructure.integration.pix;

import com.bank.transactions.domain.gateway.PixKeyGateway;
import com.bank.transactions.domain.model.PixKey;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PixKeyGatewayImpl implements PixKeyGateway {

    @Override
    public PixKey resolve(String keyValue) {

        return null;
    }
}