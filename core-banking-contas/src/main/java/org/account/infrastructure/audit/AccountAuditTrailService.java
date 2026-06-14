package com.bank.account.infrastructure.audit;

import com.bank.account.application.dto.AccountAuditItemDTO;

import java.util.List;
import java.util.stream.Collectors;

public class AccountAuditTrailService {

    private final AuditRepository auditRepository;

    public AccountAuditTrailService(
            AuditRepository auditRepository
    ) {
        this.auditRepository = auditRepository; // injeta repositório de auditoria
    }

    public List<AccountAuditItemDTO> getAuditTrail(
            String accountId
    ) {

        return auditRepository.findByAggregateId(accountId)
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList()); // converte registros para DTO
    }

    private AccountAuditItemDTO toDto(
            AuditRecord record
    ) {

        AccountAuditItemDTO dto =
                new AccountAuditItemDTO();

        dto.setAction(record.getEventType()); // ação executada
        dto.setPerformedBy(record.getActorId()); // executor
        dto.setPerformedAt(record.getTimestamp()); // data da ação

        return dto;
    }
}