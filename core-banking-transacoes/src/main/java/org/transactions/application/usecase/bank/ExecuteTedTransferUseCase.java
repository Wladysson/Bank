package com.bank.transactions.application.usecase.bank;

import com.bank.transactions.application.dto.request.bank.ExecuteTedTransferRequest;
import com.bank.transactions.application.dto.response.bank.TedTransferResponse;
import com.bank.transactions.application.service.BankTransferService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

// Use case responsável pela execução de TED
@ApplicationScoped
public class ExecuteTedTransferUseCase {

    @Inject
    BankTransferService bankTransferService;

    // Executa transferência TED para outro banco
    public TedTransferResponse execute(ExecuteTedTransferRequest request) {
        return bankTransferService.executeTedTransfer(request);
    }
}