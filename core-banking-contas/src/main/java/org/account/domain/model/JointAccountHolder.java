package com.bank.account.domain.model;

import java.util.UUID;

public class JointAccountHolder extends AccountHolder {

    public JointAccountHolder(UUID holderId) {
        super(holderId, false);
    }
}