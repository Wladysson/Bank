package com.bank.account.interfaces.rest;

import com.bank.account.application.dto.LimitConfigurationDTO;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/accounts/{accountId}/limits")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LimitController {

    @PUT
    public Response configureLimit(@PathParam("accountId") String accountId,
                                   LimitConfigurationDTO dto) {

        // mock temporário
        return Response.ok().build();
    }
}