package com.bank.account.interfaces.rest.controller;

import com.bank.account.application.dto.AccountAuditItemDTO;
import com.bank.account.infrastructure.audit.AccountAuditTrailService;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/accounts/audit")
@Produces(MediaType.APPLICATION_JSON)
public class AccountAuditController {

    private final AccountAuditTrailService auditTrailService;

    public AccountAuditController(
            AccountAuditTrailService auditTrailService
    ) {
        this.auditTrailService = auditTrailService;
    }

    @GET
    @Path("/{accountId}")
    public List<AccountAuditItemDTO> getAuditTrail(
            @PathParam("accountId") String accountId,
            @QueryParam("limit") Integer limit
    ) {

        return auditTrailService.getAuditTrail(
                accountId
        );
    }
}