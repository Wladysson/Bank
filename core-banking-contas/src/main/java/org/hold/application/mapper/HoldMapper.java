package com.bank.account.hold.application.mapper;

import com.bank.account.hold.application.dto.HoldDetailDTO;
import com.bank.account.hold.application.dto.HoldResponseDTO;
import com.bank.account.hold.domain.model.HoldBalance;

public final class HoldMapper {

    private HoldMapper() {
    }

    public static HoldResponseDTO toResponseDTO(
            HoldBalance hold
    ) {

        if (hold == null) {
            return null;
        }

        return new HoldResponseDTO(
                hold.getHoldId().getValue(),
                hold.getAccountId(),
                hold.getAmount(),
                hold.getReason(),
                hold.getStatus(),
                hold.getExpirationDate(),
                hold.getCreatedAt(),
                hold.getUpdatedAt()
        ); // converte domínio para DTO de resposta
    }

    public static HoldDetailDTO toDetailDTO(
            HoldBalance hold
    ) {

        if (hold == null) {
            return null;
        }

        return new HoldDetailDTO(
                hold.getHoldId().getValue(),
                hold.getAccountId(),
                hold.getAmount(),
                hold.getReason(),
                hold.getStatus(),
                hold.getOperationId(),
                hold.getCreatedBy(),
                hold.getReleasedBy(),
                hold.getCreatedAt(),
                hold.getUpdatedAt(),
                hold.getExpirationDate()
        ); // converte domínio para DTO detalhado
    }
}