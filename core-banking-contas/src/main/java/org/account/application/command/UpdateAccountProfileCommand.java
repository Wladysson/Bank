package com.bank.account.application.command;

import com.bank.account.account.domain.model.AccountId;
import com.bank.account.account.domain.model.AccountMetadata;
import com.bank.account.account.domain.model.AccountSettings;

public class UpdateAccountProfileCommand {

    private final AccountId accountId;
    private final AccountSettings settings;
    private final AccountMetadata metadata;

    public UpdateAccountProfileCommand(
            AccountId accountId,
            AccountSettings settings,
            AccountMetadata metadata
    ) {
        this.accountId = accountId; // conta que será atualizada
        this.settings = settings; // configurações atualizadas
        this.metadata = metadata; // metadados atualizados
    }

    public AccountId getAccountId() {
        return accountId; // retorna conta alvo
    }

    public AccountSettings getSettings() {
        return settings; // retorna novas configurações
    }

    public AccountMetadata getMetadata() {
        return metadata; // retorna novos metadados
    }
}