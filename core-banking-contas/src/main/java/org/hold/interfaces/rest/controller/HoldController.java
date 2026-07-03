package com.bank.account.hold.interfaces.rest.controller;

import com.bank.account.hold.application.command.CancelHoldCommand;
import com.bank.account.hold.application.command.CreateHoldCommand;
import com.bank.account.hold.application.command.ExtendHoldCommand;
import com.bank.account.hold.application.command.ReleaseHoldCommand;
import com.bank.account.hold.application.dto.HoldResponseDTO;
import com.bank.account.hold.application.query.GetHoldsByAccountQuery;
import com.bank.account.hold.application.service.HoldApplicationService;
import com.bank.account.hold.interfaces.rest.request.ExtendHoldRequest;
import com.bank.account.hold.interfaces.rest.request.HoldRequest;
import com.bank.account.hold.interfaces.rest.response.HoldListResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/holds")
public class HoldController {

    private final HoldApplicationService holdApplicationService;

    public HoldController(
            HoldApplicationService holdApplicationService
    ) {
        this.holdApplicationService = holdApplicationService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HoldResponseDTO createHold(
            @Valid @RequestBody HoldRequest request
    ) {

        CreateHoldCommand command = new CreateHoldCommand(
                request.getAccountId(),
                request.getAmount(),
                request.getReason(),
                request.getExpirationDate(),
                request.getOperationId()
        ); // cria comando para reservar saldo

        return holdApplicationService.createHold(command);
    }

    @PostMapping("/{holdId}/release")
    public HoldResponseDTO releaseHold(
            @PathVariable String holdId,
            @RequestBody ReleaseHoldCommand command
    ) {

        ReleaseHoldCommand releaseCommand = new ReleaseHoldCommand(
                holdId,
                command.getReason(),
                command.getReleasedBy(),
                command.getOperationId()
        ); // cria comando de liberação

        return holdApplicationService.releaseHold(releaseCommand);
    }

    @PostMapping("/{holdId}/extend")
    public HoldResponseDTO extendHold(
            @PathVariable String holdId,
            @Valid @RequestBody ExtendHoldRequest request
    ) {

        ExtendHoldCommand command = new ExtendHoldCommand(
                holdId,
                request.getNewExpirationDate(),
                request.getReason(),
                request.getRequestedBy()
        ); // cria comando de extensão

        return holdApplicationService.extendHold(command);
    }

    @PostMapping("/{holdId}/cancel")
    public HoldResponseDTO cancelHold(
            @PathVariable String holdId,
            @RequestBody CancelHoldCommand command
    ) {

        CancelHoldCommand cancelCommand = new CancelHoldCommand(
                holdId,
                command.getReason(),
                command.getCancelledBy()
        ); // cria comando de cancelamento

        return holdApplicationService.cancelHold(cancelCommand);
    }

    @GetMapping("/account/{accountId}")
    public HoldListResponse getHoldsByAccount(
            @PathVariable String accountId
    ) {

        GetHoldsByAccountQuery query =
                new GetHoldsByAccountQuery(accountId); // cria consulta por conta

        return holdApplicationService.getHolds(query);
    }
}