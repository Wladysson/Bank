package com.bank.account.limit.application.command;

import com.bank.account.limit.domain.model.AccountChannel;
import com.bank.account.limit.domain.model.LimitInterval;
import com.bank.account.limit.domain.model.LimitType;
import com.bank.account.limit.domain.model.RiskProfile;

import java.math.BigDecimal;

public class ConfigureLimitCommand {

    private final String accountId; // identificador da conta
    private final LimitType limitType; // tipo de operação controlada pelo limite
    private final AccountChannel channel; // canal ao qual o limite será aplicado
    private final LimitInterval limitInterval; // intervalo utilizado para controle do limite
    private final BigDecimal amount; // valor máximo permitido
    private final RiskProfile riskProfile; // perfil de risco utilizado pela política

    public ConfigureLimitCommand(
            String accountId,
            LimitType limitType,
            AccountChannel channel,
            LimitInterval limitInterval,
            BigDecimal amount,
            RiskProfile riskProfile
    ) {
        this.accountId = accountId;
        this.limitType = limitType;
        this.channel = channel;
        this.limitInterval = limitInterval;
        this.amount = amount;
        this.riskProfile = riskProfile;
    }

    public String getAccountId() {
        return accountId;
    }

    public LimitType getLimitType() {
        return limitType;
    }

    public AccountChannel getChannel() {
        return channel;
    }

    public LimitInterval getLimitInterval() {
        return limitInterval;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public RiskProfile getRiskProfile() {
        return riskProfile;
    }
}