package com.bank.account.application.dto;

import com.bank.account.domain.model.AccountStatus;
import com.bank.account.domain.model.AccountType;

public class AccountSummaryDTO {

    private String accountId;
    private String accountNumber;
    private AccountType accountType;
    private AccountStatus status;
    private String primaryHolderName;

    public String getAccountId() {
        return accountId; // identificador da conta
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId; // define identificador da conta
    }

    public String getAccountNumber() {
        return accountNumber; // número da conta
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber; // define número da conta
    }

    public AccountType getAccountType() {
        return accountType; // tipo da conta
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType; // define tipo da conta
    }

    public AccountStatus getStatus() {
        return status; // status atual da conta
    }

    public void setStatus(AccountStatus status) {
        this.status = status; // define status da conta
    }

    public String getPrimaryHolderName() {
        return primaryHolderName; // titular principal
    }

    public void setPrimaryHolderName(String primaryHolderName) {
        this.primaryHolderName = primaryHolderName; // define titular principal
    }
}