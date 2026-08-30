package com.bank.account.limit.application.mapper;

import com.bank.account.limit.application.dto.LimitConfigurationDTO;
import com.bank.account.limit.application.dto.LimitDetailDTO;
import com.bank.account.limit.domain.model.AccountLimit;

public final class LimitMapper {

    private LimitMapper() {
    }

    public static LimitConfigurationDTO toConfigurationDTO(
            AccountLimit accountLimit
    ) {

        if (accountLimit == null) {
            return null;
        }

        return new LimitConfigurationDTO(
                accountLimit.getLimitId().getValue(),
                accountLimit.getAccountId(),
                accountLimit.getLimitType(),
                accountLimit.getChannel(),
                accountLimit.getLimitInterval(),
                accountLimit.getConfiguredAmount(),
                accountLimit.getConsumedAmount(),
                accountLimit.getAvailableAmount(),
                accountLimit.getRiskProfile(),
                accountLimit.isActive()
        );
    }

    public static LimitDetailDTO toDetailDTO(
            AccountLimit accountLimit
    ) {

        if (accountLimit == null) {
            return null;
        }

        return new LimitDetailDTO(
                accountLimit.getLimitId().getValue(),
                accountLimit.getAccountId(),
                accountLimit.getLimitType(),
                accountLimit.getChannel(),
                accountLimit.getLimitInterval(),
                accountLimit.getConfiguredAmount(),
                accountLimit.getConsumedAmount(),
                accountLimit.getAvailableAmount(),
                accountLimit.getRiskProfile(),
                accountLimit.isActive(),
                accountLimit.getCreatedAt(),
                accountLimit.getUpdatedAt()
        );
    }
}