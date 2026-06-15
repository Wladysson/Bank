package com.bank.account.hold.application.service;

import com.bank.account.hold.application.command.CreateHoldCommand;
import com.bank.account.application.command.ReleaseHoldCommand;
import com.bank.account.domain.model.HoldBalance;
import com.bank.account.domain.repository.HoldRepository;
import com.bank.account.domain.service.HoldManagementService;

import java.util.UUID;

public class HoldApplicationService {

    private final HoldRepository holdRepository;
    private final HoldManagementService holdManagementService;

    public HoldApplicationService(
            HoldRepository holdRepository,
            HoldManagementService holdManagementService
    ) {
        this.holdRepository = holdRepository;
        this.holdManagementService = holdManagementService;
    }

    public HoldBalance createHold(CreateHoldCommand command) {

        UUID accountId = UUID.fromString(command.getAccountId());

        HoldBalance hold = holdManagementService.reserve(
                accountId,
                command.getAmount()
        );

        return holdRepository.save(
                accountId,
                hold
        );
    }
}