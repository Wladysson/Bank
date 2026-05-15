package com.bank.transactions.infrastructure.integration.bank;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.Map;

// Cliente REST responsável pelas integrações TED e DOC
@Path("/bank-transfers")
@RegisterRestClient(configKey = "bank-transfer-api")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface TedDocApiClient {

    // Executa transferência bancária
    @POST
    @Path("/execute")
    Map<String, Object> executeTransfer(
            Map<String, Object> payload
    );

    // Consulta transferência bancária
    @GET
    @Path("/{transactionId}")
    Map<String, Object> getTransfer(
            @PathParam("transactionId")
            String transactionId
    );

    // Cancela transferência bancária
    @POST
    @Path("/{transactionId}/cancel")
    void cancelTransfer(
            @PathParam("transactionId")
            String transactionId
    );

    // Verifica disponibilidade operacional
    @GET
    @Path("/availability")
    Map<String, Object> getAvailability();
}
