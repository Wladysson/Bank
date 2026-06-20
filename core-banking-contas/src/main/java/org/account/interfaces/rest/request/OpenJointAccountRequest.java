package com.bank.account.interfaces.rest.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class OpenJointAccountRequest {

    @NotBlank
    private String primaryHolderCustomerId; // titular principal da conta

    @NotEmpty
    private List<String> jointHolderCustomerIds; // cotitulares da conta

    @NotBlank
    private String branchCode; // agência responsável pela abertura

    @NotNull
    private String accountType; // tipo da conta conjunta

    @NotBlank
    private String operationMode; // AND, OR, MIXED

    private String notes; // observações da abertura

    public String getPrimaryHolderCustomerId() {
        return primaryHolderCustomerId;
    }

    public void setPrimaryHolderCustomerId(String primaryHolderCustomerId) {
        this.primaryHolderCustomerId = primaryHolderCustomerId;
    }

    public List<String> getJointHolderCustomerIds() {
        return jointHolderCustomerIds;
    }

    public void setJointHolderCustomerIds(List<String> jointHolderCustomerIds) {
        this.jointHolderCustomerIds = jointHolderCustomerIds;
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

    public String getOperationMode() {
        return operationMode;
    }

    public void setOperationMode(String operationMode) {
        this.operationMode = operationMode;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}