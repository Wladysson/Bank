package com.seubanco.transactions.interfaces.rest.mapper;

import com.seubanco.transactions.application.dto.response.receipt.TransactionReceiptResponse;
import com.seubanco.transactions.domain.model.common.Receipt;

// Mapper responsável pelos comprovantes REST
public class ReceiptRestMapper {

    // Converte comprovante para response REST
    public TransactionReceiptResponse toResponse(
            Receipt receipt
    ) {

        TransactionReceiptResponse response =
                new TransactionReceiptResponse();

        response.setReceiptId(
                receipt.getReceiptId()
        );

        response.setTransactionId(
                receipt.getTransactionId()
        );

        response.setReceiptUrl(
                receipt.getReceiptUrl()
        );

        response.setGeneratedAt(
                receipt.getGeneratedAt()
        );

        return response;
    }
}