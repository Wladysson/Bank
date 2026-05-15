package com.bank.transactions.infrastructure.integration.pix;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.Map;

// Cliente REST responsável pela integração PIX
@Path("/pix")
@RegisterRestClient(configKey = "pix-api")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface PixApiClient {

    // Executa transferência PIX
    @POST
    @Path("/transfer")
    Map<String, Object> executeTransfer(
            Map<String, Object> payload
    );

    // Consulta transação PIX
    @GET
    @Path("/{transactionId}")
    Map<String, Object> getTransaction(
            @PathParam("transactionId")
            String transactionId
    );

    // Solicita devolução PIX
    @POST
    @Path("/{transactionId}/refund")
    void refund(
            @PathParam("transactionId")
            String transactionId
    );
}