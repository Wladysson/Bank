package com.bank.transactions.domain.gateway.bank;

import com.bank.transactions.domain.model.bank.BankTransfer;

// Gateway responsável pelas integrações bancárias externas
public interface BankTransferGateway {

    // Processa transferência bancária
    BankTransfer execute(BankTransfer bankTransfer);

    // Consulta status da transferência
    BankTransfer findByTransactionId(String transactionId);

    // Valida disponibilidade operacional
    boolean isAvailable();

    // Cancela transferência bancária
    void cancel(String transactionId);
}