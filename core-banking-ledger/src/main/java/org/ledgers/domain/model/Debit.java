package com.bank.ledger.domain.model;

public class Debit extends Money {

    public Debit(Money money) {
        super(money.getValue(), money.getCurrency());
    }
}