package com.bank.ledger.interfaces.rest;

import com.bank.ledger.application.dto.JournalRequestDTO;
import com.bank.ledger.application.command.PostJournalCommand;
import com.bank.ledger.application.command.PostJournalCommand.EntryCommand;
import com.bank.ledger.application.service.JournalPostingService;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Path("/journal")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class JournalController {

    JournalPostingService journalService;

    @POST
    public Response post(JournalRequestDTO request) {

        // converte DTO → Command
        List<EntryCommand> entries = request.getEntries().stream()
                .map(e -> new EntryCommand(
                        e.getAccountNumber(),
                        e.getAmount(),
                        e.getDebit()
                ))
                .collect(Collectors.toList());

        // monta comando principal
        PostJournalCommand command = new PostJournalCommand(
                UUID.randomUUID(),
                request.getTransactionDate(),
                request.getDescription(),
                entries
        );

        journalService.postEntry(command);

        return Response.status(Response.Status.CREATED).build();
    }
}