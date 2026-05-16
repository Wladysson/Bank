package com.bank.transactions.interfaces.rest.resource.v1;

import com.bank.transactions.application.dto.request.international.ExecuteInternationalTransferRequest;
import com.bank.transactions.application.dto.response.international.InternationalTransferResponse;
import com.bank.transactions.application.usecase.international.ExecuteInternationalTransferUseCase;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

// Resource responsável pelas transferências internacionais
@Path("/v1/international-transfers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class InternationalTransferResource {

    @Inject
    ExecuteInternationalTransferUseCase executeInternationalTransferUseCase;

    // Executa transferência internacional
    @POST
    public InternationalTransferResponse execute(
            ExecuteInternationalTransferRequest request
    ) {

        return executeInternationalTransferUseCase.execute(request);
    }
}