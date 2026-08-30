package com.bank.account.hold.application.service;

import com.bank.account.hold.application.command.CreateHoldCommand;
import com.bank.account.application.command.ReleaseHoldCommand;
import com.bank.account.hold.application.command.CancelHoldCommand;
import com.bank.account.hold.application.command.ExtendHoldCommand;
import com.bank.account.hold.interfaces.rest.response.HoldListResponse;
import com.bank.account.hold.application.dto.HoldResponseDTO;
import com.bank.account.hold.application.mapper.HoldMapper;
import com.bank.account.domain.model.HoldBalance;
import com.bank.account.domain.repository.HoldRepository;
import com.bank.account.domain.service.HoldManagementService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
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

    public HoldResponseDTO createHold(CreateHoldCommand command) {

        UUID accountId = UUID.fromString(command.getAccountId());

        HoldBalance hold = holdManagementService.reserve(
                accountId,
                command.getAmount()
        );

        HoldBalance saved = holdRepository.save(
                accountId,
                hold
        );

        return HoldMapper.toResponseDTO(saved);
    }

    public HoldResponseDTO releaseHold(ReleaseHoldCommand command) {
        UUID holdId = UUID.fromString(command.getHoldId());
        // try to find hold
        return holdRepository.findById(holdId)
                .map(h -> {
                    h.release();
                    holdRepository.delete(holdId);
                    return HoldMapper.toResponseDTO(h);
                }).orElseThrow(() -> new IllegalArgumentException("Hold não encontrado"));
    }

    public HoldResponseDTO extendHold(ExtendHoldCommand command) {
        UUID holdId = UUID.fromString(command.getHoldId());
        return holdRepository.findById(holdId)
                .map(h -> HoldMapper.toResponseDTO(h))
                .orElseThrow(() -> new IllegalArgumentException("Hold não encontrado"));
    }

    public HoldResponseDTO cancelHold(CancelHoldCommand command) {
        UUID holdId = UUID.fromString(command.getHoldId());
        return holdRepository.findById(holdId)
                .map(h -> {
                    holdRepository.delete(holdId);
                    return HoldMapper.toResponseDTO(h);
                }).orElseThrow(() -> new IllegalArgumentException("Hold não encontrado"));
    }

    public HoldListResponse getHolds(com.bank.account.hold.application.query.GetHoldsByAccountQuery query) {
        UUID accountId = UUID.fromString(query.getAccountId());
        List<com.bank.account.hold.application.dto.HoldResponseDTO> list = holdRepository.findActiveByAccountId(accountId)
                .stream()
                .map(HoldMapper::toResponseDTO)
                .collect(Collectors.toList());
        return new HoldListResponse(list);
    }
}