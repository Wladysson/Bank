package com.bank.account.account.application.usecase;

import com.bank.account.account.application.command.OpenAccountCommand;
import com.bank.account.account.application.service.AccountOpeningService;
import com.bank.account.account.domain.model.Account;

public class OpenJointAccountUseCase {

    private final AccountOpeningService accountOpeningService;

    public OpenJointAccountUseCase(AccountOpeningService accountOpeningService) {
        this.accountOpeningService = accountOpeningService; // injeta serviço de abertura
    }

    public Account execute(OpenAccountCommand command) {

        return accountOpeningService.openJointAccount(command); // executa abertura de conta conjunta
    }
}