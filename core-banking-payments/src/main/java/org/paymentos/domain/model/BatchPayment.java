package com.bank.payments.domain.model;

import java.util.List;

public class BatchPayment {

    private String id;
    private List<Payment> payments;

    public BatchPayment(String id, List<Payment> payments) {
        this.id = id;
        this.payments = payments;
    }

    public String getId() { return id; }
    public List<Payment> getPayments() { return payments; }
}