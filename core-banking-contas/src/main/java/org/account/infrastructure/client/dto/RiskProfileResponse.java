package com.bank.account.infrastructure.client.dto;

public record RiskProfileResponse(
        Integer score,
        String profile,
        Boolean requiresManualApproval
) {
}
