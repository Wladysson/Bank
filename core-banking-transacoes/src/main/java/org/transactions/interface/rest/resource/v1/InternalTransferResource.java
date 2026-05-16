package com.bank.transactions.interfaces.rest.resource.v1;

import com.bank.transactions.application.dto.request.internal.ExecuteInternalTransferRequest;
import com.bank.transactions.application.dto.response.internal.InternalTransferResponse;
import com.bank.transactions.application.usecase.internal.ExecuteInternalTransferUseCase;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

// Resource responsável pelas transferências internas
@Path("/v1/internal-transfers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class InternalTransferResource {

    @Inject
    ExecuteInternalTransferUseCase executeInternalTransferUseCase;

    // Executa transferência interna
    @POST
    public InternalTransferResponse execute(
            ExecuteInternalTransferRequest request
    ) {

        return executeInternalTransferUseCase.execute(request);
    }
}