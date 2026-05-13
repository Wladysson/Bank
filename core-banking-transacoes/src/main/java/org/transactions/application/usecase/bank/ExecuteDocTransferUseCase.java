package com.banco.transactions.application.usecase.bank;

import com.seubanco.transactions.application.dto.request.bank.ExecuteDocTransferRequest;
import com.seubanco.transactions.application.dto.response.bank.DocTransferResponse;
import com.seubanco.transactions.application.service.BankTransferService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

// Use case responsável pela execução de DOC
@ApplicationScoped
public class ExecuteDocTransferUseCase {

    @Inject
    BankTransferService bankTransferService;

    // Executa transferência DOC para outro banco
    public DocTransferResponse execute(ExecuteDocTransferRequest request) {
        return bankTransferService.executeDocTransfer(request);
    }
}