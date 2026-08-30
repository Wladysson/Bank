package com.bank.account.limit.interfaces.rest;

import com.bank.account.limit.application.command.ConfigureLimitCommand;
import com.bank.account.limit.application.dto.LimitConfigurationDTO;
import com.bank.account.limit.application.query.GetLimitsByAccountQuery;
import com.bank.account.limit.application.service.LimitConfigurationApplicationService;
import com.bank.account.limit.interfaces.rest.request.ConfigureLimitRequest;
import com.bank.account.limit.interfaces.rest.response.LimitListResponse;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/api/v1/accounts/{accountId}/limits")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LimitController {

    private final LimitConfigurationApplicationService limitConfigurationApplicationService;

    public LimitController(
            LimitConfigurationApplicationService limitConfigurationApplicationService
    ) {
        this.limitConfigurationApplicationService =
                limitConfigurationApplicationService;
    }

    @POST
    public Response configureLimit(
            @PathParam("accountId") String accountId,
            @Valid ConfigureLimitRequest request
    ) {

        ConfigureLimitCommand command = new ConfigureLimitCommand(
                accountId,
                request.getLimitType(),
                request.getChannel(),
                request.getLimitInterval(),
                request.getAmount(),
                request.getRiskProfile()
        ); // transforma request REST em comando de aplicação

        LimitConfigurationDTO limit =
                limitConfigurationApplicationService.configure(command);

        return Response
                .status(Response.Status.CREATED)
                .entity(limit)
                .build(); // retorna o limite configurado
    }

    @GET
    public Response getLimits(
            @PathParam("accountId") String accountId
    ) {

        GetLimitsByAccountQuery query =
                new GetLimitsByAccountQuery(accountId); // cria consulta da conta

        List<LimitConfigurationDTO> limits =
                limitConfigurationApplicationService.getLimits(query);

        LimitListResponse response =
                new LimitListResponse(limits); // encapsula os limites retornados

        return Response
                .ok(response)
                .build(); // retorna os limites configurados
    }
}