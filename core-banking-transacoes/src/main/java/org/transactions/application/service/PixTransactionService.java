package com.bank.transactions.application.service;

import com.bank.transactions.domain.model.PixKey;
import com.bank.transactions.domain.model.PixQrCode;
import com.bank.transactions.domain.model.PixTransaction;
import com.bank.transactions.domain.model.PixExecutionResult;
import com.bank.transactions.infrastructure.integration.pix.PixGatewayImpl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.math.BigDecimal;

@ApplicationScoped
public class PixTransactionService {

    private final PixGatewayImpl pixGateway;
    private final PixKeyService pixKeyService;

    @Inject
    public PixTransactionService(
            PixGatewayImpl pixGateway,
            PixKeyService pixKeyService) {

        this.pixGateway = pixGateway;
        this.pixKeyService = pixKeyService;
    }

    // EXECUÇÃO REAL DO PIX
    public PixExecutionResult executeTransfer(PixTransaction transaction) {

        PixKey key = pixKeyService.resolve(
                transaction.getPixKey().getValue()
        );

        return pixGateway.execute(transaction, key);
    }

    // REFUND
    public PixExecutionResult refund(PixTransaction transaction) {

        return pixGateway.refund(transaction);
    }

    // STATUS
    public PixExecutionResult getStatus(String endToEndId) {

        return pixGateway.getStatus(endToEndId);
    }

    // QR CODE
    public PixQrCode generateQrCode(
            String pixKey,
            BigDecimal amount,
            String description) {

        return pixGateway.generateQrCode(
                pixKey,
                amount,
                description
        );
    }
}