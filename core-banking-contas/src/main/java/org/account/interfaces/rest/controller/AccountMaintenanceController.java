package com.bank.account.interfaces.rest.controller;

import com.bank.account.application.service.AccountMaintenanceService;
import com.bank.account.domain.model.Account;
import com.bank.account.domain.model.AccountSettings;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("/accounts/maintenance")
@ApplicationScoped
public class AccountMaintenanceController {

    private final AccountMaintenanceService maintenanceService;

    public AccountMaintenanceController(
            AccountMaintenanceService maintenanceService
    ) {
        this.maintenanceService = maintenanceService;
    }

    @PUT
    @Path("/{accountId}/settings")
    public Response updateSettings(
            @PathParam("accountId") String accountId,
            AccountSettings settings
    ) {

        // TODO: buscar conta pelo accountId
        Account account = null;

        maintenanceService.updateSettings(account, settings);

        return Response.noContent().build();
    }

    @POST
    @Path("/{accountId}/suspend")
    public Response suspend(
            @PathParam("accountId") String accountId
    ) {

        // TODO: buscar conta pelo accountId
        Account account = null;

        maintenanceService.suspendMaintenance(account);

        return Response.noContent().build();
    }

    @POST
    @Path("/{accountId}/reactivate")
    public Response reactivate(
            @PathParam("accountId") String accountId
    ) {

        // TODO: buscar conta pelo accountId
        Account account = null;

        maintenanceService.reactivate(account);

        return Response.noContent().build();
    }
}