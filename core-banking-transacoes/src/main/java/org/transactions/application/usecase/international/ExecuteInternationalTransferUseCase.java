package com.bank.transactions.application.usecase.international;

import com.bank.transactions.application.dto.request.international.ExecuteInternationalTransferRequest;
import com.bank.transactions.application.dto.response.international.InternationalTransferResponse;
import com.bank.transactions.application.service.InternationalTransferService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

// Use case responsável pela execução de transferências internacionais
@ApplicationScoped
public class ExecuteInternationalTransferUseCase {

    @Inject
    InternationalTransferService internationalTransferService;

    // Executa remessa internacional com conversão cambial
    public InternationalTransferResponse execute(ExecuteInternationalTransferRequest request) {
        return internationalTransferService.executeTransfer(request);
    }
}