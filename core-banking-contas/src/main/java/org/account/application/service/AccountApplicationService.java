package com.bank.account.application.service;

import com.bank.account.application.command.*;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class AccountApplicationService {

    @Inject
    AccountOpeningService openingService;

    @Inject
    AccountClosureService closureService;

    public void openAccount(OpenAccountCommand command) {
        openingService.open(command);
    }

    public void closeAccount(CloseAccountCommand command) {
        closureService.close(command);
    }

    public void blockAccount(BlockAccountCommand command) {
        // delegaria para lifecycle service
        // exemplo simplificado
        throw new UnsupportedOperationException("Not implemented yet");
    }
}