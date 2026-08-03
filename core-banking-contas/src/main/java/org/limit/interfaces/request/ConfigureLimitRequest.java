package com.bank.account.limit.interfaces.rest.request;

import com.bank.account.limit.domain.model.AccountChannel;
import com.bank.account.limit.domain.model.LimitInterval;
import com.bank.account.limit.domain.model.LimitType;
import com.bank.account.limit.domain.model.RiskProfile;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class ConfigureLimitRequest {

    @NotBlank
    private String accountId; // conta que receberá o limite

    @NotNull
    private LimitType limitType; // tipo de operação controlada

    @NotNull
    private AccountChannel channel; // canal de utilização

    @NotNull
    private LimitInterval limitInterval; // intervalo de controle

    @NotNull
    @DecimalMin(value = "0.01")
    private BigDecimal amount; // valor máximo solicitado

    @NotNull
    private RiskProfile riskProfile; // perfil de risco utilizado pela política

    public ConfigureLimitRequest() {
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public LimitType getLimitType() {
        return limitType;
    }

    public void setLimitType(LimitType limitType) {
        this.limitType = limitType;
    }

    public AccountChannel getChannel() {
        return channel;
    }

    public void setChannel(AccountChannel channel) {
        this.channel = channel;
    }

    public LimitInterval getLimitInterval() {
        return limitInterval;
    }

    public void setLimitInterval(LimitInterval limitInterval) {
        this.limitInterval = limitInterval;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public RiskProfile getRiskProfile() {
        return riskProfile;
    }

    public void setRiskProfile(RiskProfile riskProfile) {
        this.riskProfile = riskProfile;
    }
}