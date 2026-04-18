package com.bank.payments.infrastructure.integration.qr;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class QRDecoder {

    public String decode(String qrCode) {
        // mock simples
        return "decoded-payload:" + qrCode;
    }
}