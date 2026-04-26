package com.bank.payments.application.service;

import com.bank.payments.domain.model.QRCode;
import com.bank.payments.application.dto.response.QRCodeStatusResponse;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.NotFoundException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ApplicationScoped
public class QrCodeService {

    private final Map<String, QRCode> store = new ConcurrentHashMap<>();

    public QRCode findById(String id) {
        QRCode qr = store.get(id);

        if (qr == null) {
            throw new NotFoundException("QR Code não encontrado");
        }

        return qr;
    }

    public QRCodeStatusResponse getStatus(String id) {
        QRCode qr = findById(id);
        return new QRCodeStatusResponse(qr.getId(), qr.getStatus());
    }
}