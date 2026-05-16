package com.bank.transactions.interfaces.rest.resource.v1;

import com.bank.transactions.application.dto.request.pix.ExecutePixTransferRequest;
import com.bank.transactions.application.dto.response.pix.PixTransactionResponse;
import com.bank.transactions.application.usecase.pix.ExecutePixTransferUseCase;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

// Resource responsável pelas operações PIX
@Path("/v1/pix")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PixResource {

    @Inject
    ExecutePixTransferUseCase executePixTransferUseCase;

    // Executa transferência PIX
    @POST
    @Path("/transfer")
    public PixTransactionResponse executeTransfer(
            ExecutePixTransferRequest request
    ) {

        return executePixTransferUseCase.execute(request);
    }
}