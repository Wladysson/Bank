package com.bank.account.account.application.dto;

import com.bank.account.domain.model.AccountStatus;
import com.bank.account.domain.model.AccountType;

import java.time.Instant;
import java.util.List;

public class AccountDetailDTO {

    private String accountId;
    private String accountNumber;
    private String branchCode;
    private AccountType accountType;
    private AccountStatus status;
    private List<String> holders;
    private Instant createdAt;

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

    public String getBranchCode() {
        return branchCode; // agência da conta
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode; // define agência
    }

    public AccountType getAccountType() {
        return accountType; // tipo da conta
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType; // define tipo da conta
    }

    public AccountStatus getStatus() {
        return status; // status da conta
    }

    public void setStatus(AccountStatus status) {
        this.status = status; // define status
    }

    public List<String> getHolders() {
        return holders; // lista de titulares
    }

    public void setHolders(List<String> holders) {
        this.holders = holders; // define titulares
    }

    public Instant getCreatedAt() {
        return createdAt; // data de abertura
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt; // define data de abertura
    }
}