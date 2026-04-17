package com.bank.payments.application.dto.internal;

import java.math.BigDecimal;

public class LedgerPostingRequest {

    private String paymentId;
    private String debitAccount;
    private String creditAccount;
    private BigDecimal amount;
    private String currency;
    private String description;

    public LedgerPostingRequest() {}

    public LedgerPostingRequest(String paymentId, String debitAccount,
                                String creditAccount, BigDecimal amount,
                                String currency, String description) {
        this.paymentId = paymentId;
        this.debitAccount = debitAccount;
        this.creditAccount = creditAccount;
        this.amount = amount;
        this.currency = currency;
        this.description = description;
    }

    public String getPaymentId() { return paymentId; }
    public String getDebitAccount() { return debitAccount; }
    public String getCreditAccount() { return creditAccount; }
    public BigDecimal getAmount() { return amount; }
    public String getCurrency() { return currency; }
    public String getDescription() { return description; }

    public void setPaymentId(String paymentId) { this.paymentId = paymentId; }
    public void setDebitAccount(String debitAccount) { this.debitAccount = debitAccount; }
    public void setCreditAccount(String creditAccount) { this.creditAccount = creditAccount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
    public void setCurrency(String currency) { this.currency = currency; }
    public void setDescription(String description) { this.description = description; }
}