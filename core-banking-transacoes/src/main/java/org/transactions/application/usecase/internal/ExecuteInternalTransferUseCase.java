package com.bank.transactions.application.usecase.internal;

import com.bank.transactions.application.dto.request.internal.ExecuteInternalTransferRequest;
import com.bank.transactions.application.dto.response.internal.InternalTransferResponse;
import com.bank.transactions.application.service.InternalTransferService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

// Use case responsável pela execução de transferências internas
@ApplicationScoped
public class ExecuteInternalTransferUseCase {

    @Inject
    InternalTransferService internalTransferService;

    // Executa transferência entre contas do mesmo banco
    public InternalTransferResponse execute(ExecuteInternalTransferRequest request) {
        return internalTransferService.executeTransfer(request);
    }
}
