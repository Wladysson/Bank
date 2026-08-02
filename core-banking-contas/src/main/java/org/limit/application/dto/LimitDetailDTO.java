package com.bank.account.limit.application.dto;

import com.bank.account.limit.domain.model.AccountChannel;
import com.bank.account.limit.domain.model.LimitInterval;
import com.bank.account.limit.domain.model.LimitType;
import com.bank.account.limit.domain.model.RiskProfile;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class LimitDetailDTO {

    private String limitId; // identificador do limite
    private String accountId; // conta vinculada ao limite
    private LimitType limitType; // tipo de operação controlada
    private AccountChannel channel; // canal de utilização
    private LimitInterval interval; // período de avaliação
    private BigDecimal configuredAmount; // valor máximo configurado
    private BigDecimal consumedAmount; // valor utilizado
    private BigDecimal availableAmount; // valor restante disponível
    private RiskProfile riskProfile; // perfil de risco da conta
    private boolean active; // estado atual da configuração
    private LocalDateTime createdAt; // momento da criação
    private LocalDateTime updatedAt; // momento da última alteração

    public LimitDetailDTO() {
    }

    public LimitDetailDTO(
            String limitId,
            String accountId,
            LimitType limitType,
            AccountChannel channel,
            LimitInterval interval,
            BigDecimal configuredAmount,
            BigDecimal consumedAmount,
            BigDecimal availableAmount,
            RiskProfile riskProfile,
            boolean active,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ) {
        this.limitId = limitId;
        this.accountId = accountId;
        this.limitType = limitType;
        this.channel = channel;
        this.interval = interval;
        this.configuredAmount = configuredAmount;
        this.consumedAmount = consumedAmount;
        this.availableAmount = availableAmount;
        this.riskProfile = riskProfile;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    public LimitInterval getInterval() {
        return interval;
    }

    public void setInterval(LimitInterval interval) {
        this.interval = interval;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}