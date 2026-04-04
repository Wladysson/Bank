package com.bank.account.interfaces.rest;

import com.bank.account.application.dto.StatementResponseDTO;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/accounts/{accountId}/statement")
@Produces(MediaType.APPLICATION_JSON)
public class StatementController {

    @GET
    public StatementResponseDTO getStatement(@PathParam("accountId") String accountId) {

        // mock temporário
        return new StatementResponseDTO();
    }
}