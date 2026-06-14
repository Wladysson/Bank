package com.bank.account.application.dto;

import com.bank.account.domain.model.AccountStatus;

public class AccountStatusDTO {

    private String accountId;
    private AccountStatus status;
    private String reason;

    public String getAccountId() {
        return accountId; // identificador da conta
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId; // define identificador
    }

    public AccountStatus getStatus() {
        return status; // status atual
    }

    public void setStatus(AccountStatus status) {
        this.status = status; // define status
    }

    public String getReason() {
        return reason; // motivo do status
    }

    public void setReason(String reason) {
        this.reason = reason; // define motivo
    }
}