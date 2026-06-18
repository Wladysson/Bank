package com.bank.account.application.service;

import com.bank.account.domain.model.AccountSettings;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Map;

@ApplicationScoped
public class AccountSettingsService {

    public AccountSettings getSettings(
            String accountId
    ) {

        // TODO buscar configurações reais no repositório

        return AccountSettings.of(
                Map.of(
                        "notificationsEnabled", true,
                        "dailyTransferLimit", 5000
                )
        );
    }

    public void updateSettings(
            String accountId,
            AccountSettings settings
    ) {

        // TODO buscar conta
        // atualizar configurações
        // persistir alterações
    }
}