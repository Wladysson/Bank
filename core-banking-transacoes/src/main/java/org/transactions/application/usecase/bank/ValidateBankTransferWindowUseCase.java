package com.bank.transactions.application.usecase.bank;

import com.bank.transactions.application.service.BankTransferService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.time.LocalDateTime;

// Use case responsável por validar janela operacional TED/DOC
@ApplicationScoped
public class ValidateBankTransferWindowUseCase {

    @Inject
    BankTransferService bankTransferService;

    // Verifica se a transferência pode ser executada no horário atual
    public boolean execute(LocalDateTime requestedAt) {
        return bankTransferService.validateTransferWindow(requestedAt);
    }
}