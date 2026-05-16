package com.bank.transactions.interfaces.rest.resource.v1;

import com.bank.transactions.application.dto.request.schedule.ScheduleTransactionRequest;
import com.bank.transactions.application.dto.response.schedule.ScheduledTransactionResponse;
import com.bank.transactions.application.usecase.schedule.ScheduleTransactionUseCase;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

// Resource responsável pelos agendamentos
@Path("/v1/scheduled-transactions")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ScheduledTransactionResource {

    @Inject
    ScheduleTransactionUseCase scheduleTransactionUseCase;

    // Agenda transação financeira
    @POST
    public ScheduledTransactionResponse schedule(
            ScheduleTransactionRequest request
    ) {

        return scheduleTransactionUseCase.execute(request);
    }
}