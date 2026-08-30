package com.bank.account.limit.application.dto;

import com.bank.account.limit.domain.model.AccountChannel;
import com.bank.account.limit.domain.model.LimitInterval;
import com.bank.account.limit.domain.model.LimitType;
import com.bank.account.limit.domain.model.RiskProfile;

import java.math.BigDecimal;

public class LimitConfigurationDTO {

    private String limitId; // identificador da configuração
    private String accountId; // identificador da conta
    private LimitType limitType; // tipo de operação controlada
    private AccountChannel channel; // canal da operação
    private LimitInterval limitInterval; // intervalo de avaliação
    private BigDecimal configuredAmount; // valor configurado para o limite
    private BigDecimal consumedAmount; // valor já consumido
    private BigDecimal availableAmount; // valor ainda disponível
    private RiskProfile riskProfile; // perfil de risco associado
    private boolean active; // indica se o limite está ativo

    public LimitConfigurationDTO() {
    }

    public LimitConfigurationDTO(
            String limitId,
            String accountId,
            LimitType limitType,
            AccountChannel channel,
            LimitInterval limitInterval,
            BigDecimal configuredAmount,
            BigDecimal consumedAmount,
            BigDecimal availableAmount,
            RiskProfile riskProfile,
            boolean active
    ) {
        this.limitId = limitId;
        this.accountId = accountId;
        this.limitType = limitType;
        this.channel = channel;
        this.limitInterval = limitInterval;
        this.configuredAmount = configuredAmount;
        this.consumedAmount = consumedAmount;
        this.availableAmount = availableAmount;
        this.riskProfile = riskProfile;
        this.active = active;
    }

    public String getLimitId() {
        return limitId;
    }

    public void setLimitId(String limitId) {
        this.limitId = limitId;
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

    public BigDecimal getConfiguredAmount() {
        return configuredAmount;
    }

    public void setConfiguredAmount(BigDecimal configuredAmount) {
        this.configuredAmount = configuredAmount;
    }

    public BigDecimal getConsumedAmount() {
        return consumedAmount;
    }

    public void setConsumedAmount(BigDecimal consumedAmount) {
        this.consumedAmount = consumedAmount;
    }

    public BigDecimal getAvailableAmount() {
        return availableAmount;
    }

    public void setAvailableAmount(BigDecimal availableAmount) {
        this.availableAmount = availableAmount;
    }

    public RiskProfile getRiskProfile() {
        return riskProfile;
    }

    public void setRiskProfile(RiskProfile riskProfile) {
        this.riskProfile = riskProfile;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}