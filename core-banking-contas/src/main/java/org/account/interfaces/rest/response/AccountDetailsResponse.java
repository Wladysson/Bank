package com.bank.account.interfaces.rest.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class AccountDetailsResponse {

    private String accountId; // identificador único da conta

    private String accountNumber; // número da conta

    private String branchCode; // agência da conta

    private String accountType; // tipo da conta

    private String status; // status atual da conta

    private String primaryHolderId; // titular principal

    private List<String> jointHolderIds; // cotitulares

    private BigDecimal availableBalance; // saldo disponível

    private BigDecimal blockedBalance; // saldo reservado/bloqueado

    private LocalDateTime openedAt; // data de abertura

    private LocalDateTime updatedAt; // última atualização

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPrimaryHolderId() {
        return primaryHolderId;
    }

    public void setPrimaryHolderId(String primaryHolderId) {
        this.primaryHolderId = primaryHolderId;
    }

    public List<String> getJointHolderIds() {
        return jointHolderIds;
    }

    public void setJointHolderIds(List<String> jointHolderIds) {
        this.jointHolderIds = jointHolderIds;
    }

    public BigDecimal getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(BigDecimal availableBalance) {
        this.availableBalance = availableBalance;
    }

    public BigDecimal getBlockedBalance() {
        return blockedBalance;
    }

    public void setBlockedBalance(BigDecimal blockedBalance) {
        this.blockedBalance = blockedBalance;
    }

    public LocalDateTime getOpenedAt() {
        return openedAt;
    }

    public void setOpenedAt(LocalDateTime openedAt) {
        this.openedAt = openedAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}