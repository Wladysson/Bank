package com.bank.account.hold.application.service;

import com.bank.account.hold.application.command.CreateHoldCommand;
import com.bank.account.hold.application.command.ExtendHoldCommand;
import com.bank.account.hold.application.command.CancelHoldCommand;
import com.bank.account.hold.application.command.ReleaseHoldCommand;
import com.bank.account.hold.domain.model.HoldBalance;
import com.bank.account.hold.domain.model.HoldStatus;
import com.bank.account.hold.domain.repository.HoldRepository;
import com.bank.account.hold.domain.service.HoldManagementService;

import java.time.LocalDateTime;

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

    public HoldBalance createHold(
            CreateHoldCommand command
    ) {

        HoldBalance hold = holdManagementService.create(
                command.getAccountId(),
                command.getAmount(),
                command.getReason(),
                command.getExpirationDate()
        ); // cria regra de negócio do hold

        return holdRepository.save(hold); // persiste hold criado
    }

    public HoldBalance releaseHold(
            ReleaseHoldCommand command
    ) {

        HoldBalance hold = holdRepository.findById(command.getHoldId())
                .orElseThrow(() -> new IllegalArgumentException("Hold not found"));

        hold.setStatus(HoldStatus.RELEASED); // libera reserva

        hold.setUpdatedAt(LocalDateTime.now()); // atualiza timestamp

        return holdRepository.save(hold); // persiste liberação
    }

    public HoldBalance cancelHold(
            CancelHoldCommand command
    ) {

        HoldBalance hold = holdRepository.findById(command.getHoldId())
                .orElseThrow(() -> new IllegalArgumentException("Hold not found"));

        hold.setStatus(HoldStatus.CANCELLED); // cancela reserva

        hold.setUpdatedAt(LocalDateTime.now()); // atualiza timestamp

        return holdRepository.save(hold); // persiste cancelamento
    }

    public HoldBalance extendHold(
            ExtendHoldCommand command
    ) {

        HoldBalance hold = holdRepository.findById(command.getHoldId())
                .orElseThrow(() -> new IllegalArgumentException("Hold not found"));

        hold.setExpirationDate(command.getNewExpirationDate()); // estende expiração

        hold.setUpdatedAt(LocalDateTime.now()); // atualiza timestamp

        return holdRepository.save(hold); // persiste extensão
    }
}