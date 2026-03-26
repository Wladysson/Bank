package com.bank.account.infrastructure.document;

import com.bank.account.domain.model.Account;
import com.bank.account.domain.model.AccountHolder;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OwnershipCertificateGenerator {

    public String generate(Account account) {

        StringBuilder sb = new StringBuilder();

        sb.append("==== CERTIFICADO DE TITULARIDADE ====\n\n");

        sb.append("Conta: ").append(account.getAccountNumber()).append("\n");
        sb.append("Tipo: ").append(account.getType()).append("\n");
        sb.append("Status: ").append(account.getStatus()).append("\n\n");

        sb.append("Titulares:\n");

        for (AccountHolder holder : account.getHolders()) {
            sb.append("- ID: ").append(holder.getHolderId());
            sb.append(holder.isPrimary() ? " (Principal)" : "");
            sb.append("\n");
        }

        sb.append("\nEste documento certifica a titularidade da conta do cliente.\n");

        return sb.toString();
    }
}