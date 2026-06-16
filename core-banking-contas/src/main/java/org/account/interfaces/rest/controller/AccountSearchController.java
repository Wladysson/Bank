package com.bank.account.interfaces.rest.controller;

import com.bank.account.application.service.AccountSearchService;
import com.bank.account.domain.model.Account;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.Optional;
import java.util.UUID;

@Path("/accounts/search")
@Produces(MediaType.APPLICATION_JSON)
public class AccountSearchController {

    private final AccountSearchService accountSearchService;

    public AccountSearchController(
            AccountSearchService accountSearchService
    ) {
        this.accountSearchService = accountSearchService;
    }

    @GET
    @Path("/{accountId}")
    public Optional<Account> getById(
            @PathParam("accountId") String accountId
    ) {
        return accountSearchService.findById(
                UUID.fromString(accountId)
        );
    }
}