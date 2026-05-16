package com.bank.transactions.interfaces.rest.mapper;

import com.bank.transactions.application.dto.response.pix.PixQrCodeResponse;
import com.bank.transactions.application.dto.response.pix.PixTransactionResponse;
import com.bank.transactions.domain.model.pix.PixTransaction;

// Mapper responsável pelas respostas REST do PIX
public class PixRestMapper {

    // Converte domínio para response PIX
    public PixTransactionResponse toResponse(
            PixTransaction pixTransaction
    ) {

        PixTransactionResponse response =
                new PixTransactionResponse();

        response.setTransactionId(
                pixTransaction.getTransactionId().getValue()
        );

        response.setStatus(
                pixTransaction.getStatus().name()
        );

        response.setAmount(
                pixTransaction.getAmount().getAmount()
        );

        response.setCreatedAt(
                pixTransaction.getCreatedAt()
        );

        return response;
    }

    // Converte QR Code para response
    public PixQrCodeResponse toQrCodeResponse(
            String qrCode,
            String transactionId
    ) {

        PixQrCodeResponse response =
                new PixQrCodeResponse();

        response.setQrCode(qrCode);
        response.setTransactionId(transactionId);

        return response;
    }
}