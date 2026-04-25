package com.bank.payments.application.dto.response;

import com.bank.payments.domain.model.Boleto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BoletoResponse {

    private String id;
    private String payerName;
    private String payerDocument;
    private BigDecimal amount;
    private LocalDate dueDate;
    private String barcode;
    private String digitableLine;
    private String status;

    public static BoletoResponse from(Boleto boleto) {
        BoletoResponse response = new BoletoResponse();
        response.id = boleto.getId();
        response.payerName = boleto.getPayerName();
        response.payerDocument = boleto.getPayerDocument();
        response.amount = boleto.getAmount();
        response.dueDate = boleto.getDueDate();
        response.barcode = boleto.getBarcode();
        response.digitableLine = boleto.getDigitableLine();
        response.status = boleto.getStatus().name();
        return response;
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

    public String getStatus() {
        return status;
    }
}