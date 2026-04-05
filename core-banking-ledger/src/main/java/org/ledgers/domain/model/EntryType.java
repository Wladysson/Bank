package com.bank.ledger.domain.model;

public enum EntryType {

    DEBIT,
    CREDIT;

    public EntryType reverse() {
        return this == DEBIT ? CREDIT : DEBIT;
    }
}