package com.bank.payments.infrastructure.integration.nfc;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class NFCProcessor {

    public boolean process(String token) {
        // simulação
        System.out.println("Processando NFC token: " + token);
        return true;
    }
}