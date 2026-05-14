package com.bank.transactions.domain.gateway.pix;

import com.seubanco.transactions.domain.model.pix.PixTransaction;

// Gateway responsável pela integração de transações PIX
public interface PixGateway {

    // Envia transação PIX para liquidação
    PixTransaction execute(PixTransaction pixTransaction);

    // Consulta status da transação PIX
    PixTransaction findByTransactionId(String transactionId);

    // Solicita devolução da transação PIX
    void refund(String transactionId);
}