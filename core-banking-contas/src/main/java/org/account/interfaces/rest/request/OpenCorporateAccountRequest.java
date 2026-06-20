package com.bank.account.interfaces.rest.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class OpenCorporateAccountRequest {

    @NotBlank
    private String companyCustomerId; // identificador da empresa

    @NotBlank
    private String companyName; // razão social

    @NotBlank
    private String taxId; // cnpj

    @NotBlank
    private String branchCode; // agência responsável

    @NotNull
    private String accountType; // tipo da conta pj

    @NotBlank
    private String legalRepresentativeId; // representante legal

    @Email
    private String companyEmail; // email corporativo

    private String companyPhone; // telefone corporativo

    public String getCompanyCustomerId() {
        return companyCustomerId;
    }

    public void setCompanyCustomerId(String companyCustomerId) {
        this.companyCustomerId = companyCustomerId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
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

    public String getLegalRepresentativeId() {
        return legalRepresentativeId;
    }

    public void setLegalRepresentativeId(String legalRepresentativeId) {
        this.legalRepresentativeId = legalRepresentativeId;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }
}