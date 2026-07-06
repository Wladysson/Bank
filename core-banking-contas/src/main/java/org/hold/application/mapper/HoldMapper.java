package com.bank.account.hold.application.mapper;

import com.bank.account.hold.application.dto.HoldDetailDTO;
import com.bank.account.hold.application.dto.HoldResponseDTO;
import com.bank.account.hold.domain.model.HoldStatus;
import com.bank.account.domain.model.HoldBalance;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public final class HoldMapper {

    private HoldMapper() {
    }

    private static LocalDateTime toLocalDateTime(Instant instant) {
        return instant == null ? null : LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    }

    public static HoldResponseDTO toResponseDTO(HoldBalance hold) {
        if (hold == null) return null;

        HoldStatus status = hold.isActive() ? HoldStatus.ACTIVE : HoldStatus.RELEASED;

        HoldResponseDTO dto = new HoldResponseDTO();
        dto.setHoldId(hold.getHoldId().toString());
        dto.setAccountId(null);
        dto.setAmount(hold.getAmount());
        dto.setReason(null);
        dto.setStatus(status);
        dto.setExpirationDate(null);
        dto.setCreatedAt(toLocalDateTime(hold.getCreatedAt()));
        dto.setUpdatedAt(toLocalDateTime(hold.getReleasedAt()));
        return dto;
    }

    public static HoldDetailDTO toDetailDTO(HoldBalance hold) {
        if (hold == null) return null;

        // For now reuse response DTO values for detailed DTO where possible
        return new HoldDetailDTO(
                hold.getHoldId().toString(),
                null,
                hold.getAmount(),
                null,
                hold.isActive() ? HoldStatus.ACTIVE : HoldStatus.RELEASED,
                null,
                null,
                null,
                toLocalDateTime(hold.getCreatedAt()),
                toLocalDateTime(hold.getReleasedAt()),
                null
        );
    }
}