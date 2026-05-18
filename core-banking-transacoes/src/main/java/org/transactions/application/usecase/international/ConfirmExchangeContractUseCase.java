package com.bank.transactions.application.usecase.international;

import com.bank.transactions.application.service.InternationalTransferService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

// Use case responsável pela confirmação de contrato cambial
@ApplicationScoped
public class ConfirmExchangeContractUseCase {

    @Inject
    InternationalTransferService internationalTransferService;

    // Confirma contrato de câmbio antes da liquidação
    public void execute(String exchangeContractId) {
        internationalTransferService.confirmExchangeContract(exchangeContractId);
    }
}