package com.bank.account.application.usecase;

import com.bank.account.application.command.OpenAccountCommand;
import com.bank.account.application.service.AccountOpeningService;
import com.bank.account.domain.model.Account;

public class OpenCorporateAccountUseCase {

    private final AccountOpeningService accountOpeningService;

    public OpenCorporateAccountUseCase(AccountOpeningService accountOpeningService) {
        this.accountOpeningService = accountOpeningService; // injeta serviço de abertura
    }

    public Account execute(OpenAccountCommand command) {

        return accountOpeningService.open(command); // executa abertura de conta PJ
    }
}