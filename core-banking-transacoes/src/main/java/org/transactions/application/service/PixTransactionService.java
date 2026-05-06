package com.bank.transactions.application.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class PixTransactionService {

    private final PixGateway pixGateway;
    private final PixKeyService pixKeyService;

    @Inject
    public PixTransactionService(
            PixGateway pixGateway,
            PixKeyService pixKeyService) {
        this.pixGateway = pixGateway;
        this.pixKeyService = pixKeyService;
    }

    // EXECUÇÃO REAL DO PIX (integração externa)
    public PixExecutionResult executeTransfer(PixTransaction transaction) {

        // valida/enriquece chave antes de enviar
        PixKey key = pixKeyService.validate(transaction.getPixKey().getValue());

        // chama o banco / SPI do PIX
        return pixGateway.execute(transaction, key);
    }

    // REFUND EXTERNO (quando aplicável)
    public PixExecutionResult refund(PixTransaction transaction) {

        return pixGateway.refund(transaction);
    }

    // CONSULTA STATUS EXTERNO (opcional)
    public PixExecutionResult getStatus(String endToEndId) {
        return pixGateway.getStatus(endToEndId);
    }

    // GERAÇÃO DE QR CODE (delegado)
    public PixQrCode generateQrCode(String pixKey, BigDecimal amount, String description) {
        return pixGateway.generateQrCode(pixKey, amount, description);
    }
}