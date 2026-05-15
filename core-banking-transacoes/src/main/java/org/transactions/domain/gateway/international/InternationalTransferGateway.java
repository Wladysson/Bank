package com.bank.transactions.domain.gateway.international;

import com.bank.transactions.domain.model.international.InternationalTransfer;

// Gateway responsável pelas remessas internacionais
public interface InternationalTransferGateway {

    // Processa transferência internacional
    InternationalTransfer execute(
            InternationalTransfer internationalTransfer
    );

    // Consulta transferência internacional
    InternationalTransfer findByTransactionId(String transactionId);

    // Cancela remessa internacional
    void cancel(String transactionId);
}