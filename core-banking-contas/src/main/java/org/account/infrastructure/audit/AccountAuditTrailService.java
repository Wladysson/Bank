package com.bank.account.infrastructure.audit;

import com.bank.account.application.dto.AccountAuditItemDTO;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class AccountAuditTrailService {

    private final AuditRepository auditRepository;

    public AccountAuditTrailService(
            AuditRepository auditRepository
    ) {
        this.auditRepository = auditRepository;
    }

    public List<AccountAuditItemDTO> getAuditTrail(
            String accountId
    ) {

        return auditRepository.findByAggregateId(accountId)
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    private AccountAuditItemDTO toDto(
            AuditRecord record
    ) {

        AccountAuditItemDTO dto =
                new AccountAuditItemDTO();

        dto.setAction(record.getEventType());
        dto.setPerformedBy(record.getActorId());
        dto.setPerformedAt(record.getTimestamp());

        return dto;
    }
}