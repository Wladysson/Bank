package com.bank.transactions.interfaces.rest.resource.v1;

import com.bank.transactions.application.dto.request.bank.ExecuteTedTransferRequest;
import com.bank.transactions.application.dto.response.bank.TedTransferResponse;
import com.bank.transactions.application.usecase.bank.ExecuteTedTransferUseCase;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

// Resource responsável pelas transferências bancárias
@Path("/v1/bank-transfers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BankTransferResource {

    @Inject
    ExecuteTedTransferUseCase executeTedTransferUseCase;

    // Executa transferência TED
    @POST
    @Path("/ted")
    public TedTransferResponse executeTed(
            ExecuteTedTransferRequest request
    ) {

        return executeTedTransferUseCase.execute(request);
    }
}