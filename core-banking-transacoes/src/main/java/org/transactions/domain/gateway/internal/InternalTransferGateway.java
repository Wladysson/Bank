package com.bank.transactions.domain.gateway.internal;

import com.seubanco.transactions.domain.model.internal.InternalTransfer;

// Gateway responsável pelas transferências internas
public interface InternalTransferGateway {

    // Processa transferência entre contas internas
    InternalTransfer execute(InternalTransfer internalTransfer);

    // Consulta transferência interna pelo identificador
    InternalTransfer findByTransactionId(String transactionId);

    // Cancela transferência interna
    void cancel(String transactionId);
}