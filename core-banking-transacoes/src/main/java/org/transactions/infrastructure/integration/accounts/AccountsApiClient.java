package com.bank.transactions.infrastructure.integration.accounts;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.math.BigDecimal;
import java.util.Map;

// Cliente REST responsável pela integração com contas
@Path("/accounts")
@RegisterRestClient(configKey = "accounts-api")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface AccountsApiClient {

    // Consulta saldo da conta
    @GET
    @Path("/{accountId}/balance")
    Map<String, Object> getBalance(
            @PathParam("accountId")
            String accountId
    );

    // Verifica status da conta
    @GET
    @Path("/{accountId}/status")
    Map<String, Object> getAccountStatus(
            @PathParam("accountId")
            String accountId
    );

    // Valida saldo disponível
    @POST
    @Path("/{accountId}/validate-balance")
    Map<String, Object> validateBalance(
            @PathParam("accountId")
            String accountId,
            BigDecimal amount
    );
}