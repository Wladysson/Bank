package com.bank.ledger.domain.model;

public class Credit extends Money {

    public Credit(Money money) {
        super(money.getValue(), money.getCurrency());
    }
}