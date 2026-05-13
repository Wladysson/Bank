package com.bank.transactions.application.service;

import com.bank.transactions.application.dto.request.internal.ExecuteInternalTransferRequest;
import com.bank.transactions.application.dto.response.internal.InternalTransferResponse;
import jakarta.enterprise.context.ApplicationScoped;

// Serviço responsável pelas transferências internas
@ApplicationScoped
public class InternalTransferService {

    // Executa transferência entre contas internas
    public InternalTransferResponse executeTransfer(ExecuteInternalTransferRequest request) {
        return new InternalTransferResponse();
    }
}