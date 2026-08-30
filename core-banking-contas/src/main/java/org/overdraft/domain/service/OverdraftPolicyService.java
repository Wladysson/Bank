package com.bank.account.overdraft.domain.service;

import com.bank.account.overdraft.domain.model.OverdraftLimit;
import com.bank.account.limit.domain.model.RiskProfile;

import java.math.BigDecimal;

public class OverdraftPolicyService {

    public BigDecimal calculateLimit(
            BigDecimal baseAmount,
            RiskProfile riskProfile
    ) {

        if (baseAmount == null || baseAmount.signum() < 0) {
            throw new IllegalArgumentException(
                    "Base overdraft amount cannot be negative"
            ); // impede política baseada em valor inválido
        }

        if (riskProfile == null) {
            throw new IllegalArgumentException(
                    "Risk profile cannot be null"
            ); // perfil de risco é obrigatório
        }

        return switch (riskProfile) {

            case LOW -> baseAmount; // mantém limite integral

            case MEDIUM -> baseAmount.multiply(
                    new BigDecimal("0.80")
            ); // reduz limite para risco médio

            case HIGH -> baseAmount.multiply(
                    new BigDecimal("0.50")
            ); // reduz limite para risco alto

            case VERY_HIGH -> baseAmount.multiply(
                    new BigDecimal("0.25")
            ); // reduz significativamente o limite

            case RESTRICTED -> BigDecimal.ZERO; // não permite cheque especial
        };
    }

    public boolean isEligible(
            RiskProfile riskProfile
    ) {

        if (riskProfile == null) {
            return false; // perfil inexistente não é elegível
        }

        return riskProfile != RiskProfile.RESTRICTED; // perfil restrito não possui cheque especial
    }

    public boolean exceedsPolicy(
            BigDecimal requestedAmount,
            BigDecimal allowedAmount
    ) {

        if (requestedAmount == null
                || allowedAmount == null) {
            return true; // dados inválidos devem ser rejeitados
        }

        return requestedAmount.compareTo(
                allowedAmount
        ) > 0; // verifica se solicitação excede a política
    }

    public OverdraftLimit createLimit(
            BigDecimal baseAmount,
            RiskProfile riskProfile
    ) {

        if (!isEligible(riskProfile)) {
            throw new IllegalStateException(
                    "Account is not eligible for overdraft"
            ); // impede criação para perfil restrito
        }

        BigDecimal calculatedAmount =
                calculateLimit(
                        baseAmount,
                        riskProfile
                ); // calcula limite conforme risco

        return new OverdraftLimit(
                calculatedAmount
        ); // cria limite aprovado pela política
    }
}