package com.bank.transactions.interfaces.rest.mapper;

import com.bank.transactions.application.dto.response.bank.TedTransferResponse;
import com.bank.transactions.application.dto.response.internal.InternalTransferResponse;
import com.bank.transactions.domain.model.bank.BankTransfer;
import com.bank.transactions.domain.model.internal.InternalTransfer;

// Mapper responsável pelas transferências REST
public class TransferRestMapper {

    // Converte transferência interna para response
    public InternalTransferResponse toInternalResponse(
            InternalTransfer internalTransfer
    ) {

        InternalTransferResponse response =
                new InternalTransferResponse();

        response.setTransactionId(
                internalTransfer.getTransactionId().getValue()
        );

        response.setStatus(
                internalTransfer.getStatus().name()
        );

        response.setAmount(
                internalTransfer.getAmount().getAmount()
        );

        return response;
    }

    // Converte TED para response
    public TedTransferResponse toTedResponse(
            BankTransfer bankTransfer
    ) {

        TedTransferResponse response =
                new TedTransferResponse();

        response.setTransactionId(
                bankTransfer.getTransactionId().getValue()
        );

        response.setStatus(
                bankTransfer.getStatus().name()
        );

        response.setAmount(
                bankTransfer.getAmount().getAmount()
        );

        return response;
    }
}