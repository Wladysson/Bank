package com.bank.account.infrastructure.client.dto;

public record RiskAnalysisResult(
        Integer score,
        String classification,
        Boolean approved
) {
}
