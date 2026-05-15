package com.bank.transactions.infrastructure.integration.remittance;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.Map;

// Cliente REST responsável pelas remessas internacionais
@Path("/international-transfers")
@RegisterRestClient(configKey = "international-remittance-api")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface InternationalRemittanceApiClient {

    // Executa remessa internacional
    @POST
    @Path("/execute")
    Map<String, Object> executeTransfer(
            Map<String, Object> payload
    );

    // Consulta transferência internacional
    @GET
    @Path("/{transactionId}")
    Map<String, Object> getTransfer(
            @PathParam("transactionId")
            String transactionId
    );

    // Cancela remessa internacional
    @POST
    @Path("/{transactionId}/cancel")
    void cancelTransfer(
            @PathParam("transactionId")
            String transactionId
    );
}