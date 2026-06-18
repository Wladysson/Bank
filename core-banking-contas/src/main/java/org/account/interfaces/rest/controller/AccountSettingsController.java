package com.bank.account.interfaces.rest.controller;

import com.bank.account.application.service.AccountSettingsService;
import com.bank.account.domain.model.AccountSettings;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
@Path("/accounts/settings")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AccountSettingsController {

    private final AccountSettingsService settingsService;

    public AccountSettingsController(
            AccountSettingsService settingsService
    ) {
        this.settingsService = settingsService;
    }

    @GET
    @Path("/{accountId}")
    public AccountSettings getSettings(
            @PathParam("accountId") String accountId
    ) {

        return settingsService.getSettings(accountId);
    }

    @PUT
    @Path("/{accountId}")
    public Response updateSettings(
            @PathParam("accountId") String accountId,
            AccountSettings settings
    ) {

        settingsService.updateSettings(
                accountId,
                settings
        );

        return Response.noContent().build();
    }
}