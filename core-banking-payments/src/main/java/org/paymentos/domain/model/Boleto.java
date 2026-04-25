package com.bank.payments.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Boleto {

    private String id;
    private String payerName;
    private String payerDocument;
    private BigDecimal amount;
    private LocalDate dueDate;
    private String barcode;
    private String digitableLine;
    private BoletoStatus status;
    private String beneficiary;

    public Boleto() {
    }

    public Boleto(
            String id,
            String payerName,
            String payerDocument,
            BigDecimal amount,
            LocalDate dueDate,
            String barcode,
            String digitableLine,
            String beneficiary,
            BoletoStatus status
    ) {
        this.id = id;
        this.payerName = payerName;
        this.payerDocument = payerDocument;
        this.amount = amount;
        this.dueDate = dueDate;
        this.barcode = barcode;
        this.digitableLine = digitableLine;
        this.beneficiary = beneficiary;
        this.status = status;
    }

    public void cancel() {
        if (this.status == BoletoStatus.PAID) {
            throw new IllegalStateException("Paid boleto cannot be cancelled");
        }

        if (this.status == BoletoStatus.CANCELLED) {
            throw new IllegalStateException("Boleto is already cancelled");
        }

        this.status = BoletoStatus.CANCELLED;
    }

    public boolean isCancelable() {
        return status != BoletoStatus.PAID
                && status != BoletoStatus.CANCELLED
                && status != BoletoStatus.EXPIRED;
    }

    public String getId() {
        return id;
    }

    public String getPayerName() {
        return payerName;
    }

    public String getPayerDocument() {
        return payerDocument;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getDigitableLine() {
        return digitableLine;
    }

    public BoletoStatus getStatus() {
        return status;
    }

    public String getBeneficiary() {
        return beneficiary;
    }
}