package com.bank.account.application.service;

import com.bank.account.domain.model.Account;
import com.bank.account.domain.model.AccountSettings;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AccountMaintenanceService {

    public void updateSettings(Account account, AccountSettings settings) {
        account.updateSettings(settings); // atualiza configurações da conta
    }

    public void suspendMaintenance(Account account) {
        account.suspend(); // suspende conta para manutenção
    }

    public void reactivate(Account account) {
        account.reactivate(); // reativa conta após manutenção
    }
}