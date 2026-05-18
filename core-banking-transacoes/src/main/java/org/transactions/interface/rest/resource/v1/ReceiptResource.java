package com.bank.transactions.interfaces.rest.resource.v1;

import com.bank.transactions.application.dto.request.receipt.GetReceiptRequest;
import com.bank.transactions.application.dto.response.receipt.TransactionReceiptResponse;
import com.bank.transactions.application.usecase.receipt.GetTransactionReceiptUseCase;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

// Resource responsável pelos comprovantes
@Path("/v1/receipts")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ReceiptResource {

    @Inject
    GetTransactionReceiptUseCase getTransactionReceiptUseCase;

    // Busca comprovante financeiro
    @POST
    @Path("/find")
    public TransactionReceiptResponse getReceipt(
            GetReceiptRequest request
    ) {

        return getTransactionReceiptUseCase.execute(request.getTransactionId());
    }
}