package com.bank.account.domain.service;

import java.util.Random;

public final class AccountNumberGenerator {

    private static final String PREFIX = "ACCT";

    public String generate() {
        int random = new Random().nextInt(99999999); // geração simples para baseline

        return PREFIX + "-" + String.format("%08d", random); // padronização do número
    }
}