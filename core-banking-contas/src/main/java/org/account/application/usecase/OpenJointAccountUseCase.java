package com.bank.account.application.usecase;

import com.bank.account.application.command.OpenAccountCommand;
import com.bank.account.application.service.AccountOpeningService;
import com.bank.account.domain.model.Account;

public class OpenJointAccountUseCase {

    private final AccountOpeningService accountOpeningService;

    public OpenJointAccountUseCase(AccountOpeningService accountOpeningService) {
        this.accountOpeningService = accountOpeningService; // injeta serviço de abertura
    }

    public Account execute(OpenAccountCommand command) {

        return accountOpeningService.open(command); // executa abertura de conta conjunta
    }
}