package com.bank.account.limit.domain.service;

import com.bank.account.limit.domain.model.AccountChannel;
import com.bank.account.limit.domain.model.AccountLimit;
import com.bank.account.limit.domain.model.LimitType;
import com.bank.account.limit.domain.model.RiskProfile;

import java.math.BigDecimal;

public class LimitPolicyService {

    public BigDecimal calculateLimit(
            LimitType limitType,
            AccountChannel channel,
            RiskProfile riskProfile
    ) {

        if (limitType == null || channel == null || riskProfile == null) {
            return BigDecimal.ZERO; // política inválida não gera limite
        }

        BigDecimal baseLimit = getBaseLimit(limitType); // obtém limite base da operação

        return applyRiskAdjustment(
                baseLimit,
                riskProfile
        ); // aplica fator de risco ao limite base
    }

    private BigDecimal getBaseLimit(
            LimitType limitType
    ) {

        return switch (limitType) {
            case PIX_TRANSFER -> new BigDecimal("10000.00");
            case TED_TRANSFER -> new BigDecimal("50000.00");
            case ATM_WITHDRAWAL -> new BigDecimal("5000.00");
            case CARD_PURCHASE -> new BigDecimal("20000.00");
            case BILL_PAYMENT -> new BigDecimal("10000.00");
            case ACCOUNT_TRANSFER -> new BigDecimal("25000.00");
            case INTERNATIONAL_TRANSFER -> new BigDecimal("100000.00");
            case INVESTMENT -> new BigDecimal("500000.00");
            case LOAN_OPERATION -> new BigDecimal("1000000.00");
            case DAILY_TRANSACTION -> new BigDecimal("50000.00");
            case MONTHLY_TRANSACTION -> new BigDecimal("500000.00");
            case OTHER -> BigDecimal.ZERO;
        }; // define o limite base conforme o tipo de operação
    }

    private BigDecimal applyRiskAdjustment(
            BigDecimal baseLimit,
            RiskProfile riskProfile
    ) {

        return switch (riskProfile) {
            case LOW -> baseLimit; // mantém limite integral para baixo risco

            case MEDIUM -> baseLimit.multiply(
                    new BigDecimal("0.80")
            ); // reduz limite para risco intermediário

            case HIGH -> baseLimit.multiply(
                    new BigDecimal("0.50")
            ); // reduz limite para alto risco

            case VERY_HIGH -> baseLimit.multiply(
                    new BigDecimal("0.25")
            ); // reduz significativamente o limite

            case RESTRICTED -> BigDecimal.ZERO; // bloqueia operações limitadas
        };
    }
}