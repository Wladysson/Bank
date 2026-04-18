package com.bank.payments.infrastructure.integration.ledger;

import com.bank.payments.application.dto.internal.LedgerPostingRequest;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/ledger")
@RegisterRestClient(configKey = "ledger-api")
public interface LedgerClient {

    @POST
    @Path("/post")
    @Consumes(MediaType.APPLICATION_JSON)
    void postTransaction(LedgerPostingRequest request);
}