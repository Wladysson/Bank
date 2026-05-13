package com.bank.transactions.infrastructure.integration.pix;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class PixGatewayImpl implements PixGateway {

    private final PixApiClient pixApiClient;

    @Inject
    public PixGatewayImpl(PixApiClient pixApiClient) {
        this.pixApiClient = pixApiClient;
    }

    @Override
    public PixExecutionResult execute(PixTransaction transaction) {

        return pixApiClient.execute(transaction);
    }

    @Override
    public PixExecutionResult refund(PixTransaction transaction) {

        return pixApiClient.refund(transaction);
    }

    @Override
    public PixExecutionResult getStatus(String endToEndId) {

        return pixApiClient.getStatus(endToEndId);
    }
}