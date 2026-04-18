package com.bank.payments.domain.model;

import java.time.LocalDate;

public class Boleto {

    private String linhaDigitavel;
    private String beneficiary;
    private LocalDate dueDate;

    public Boleto(String linhaDigitavel, String beneficiary, LocalDate dueDate) {
        this.linhaDigitavel = linhaDigitavel;
        this.beneficiary = beneficiary;
        this.dueDate = dueDate;
    }

    public String getLinhaDigitavel() { return linhaDigitavel; }
    public String getBeneficiary() { return beneficiary; }
    public LocalDate getDueDate() { return dueDate; }
}