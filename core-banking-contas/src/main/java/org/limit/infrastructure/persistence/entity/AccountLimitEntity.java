package com.bank.account.limit.infrastructure.persistence.entity;

import com.bank.account.limit.domain.model.AccountChannel;
import com.bank.account.limit.domain.model.LimitInterval;
import com.bank.account.limit.domain.model.LimitType;
import com.bank.account.limit.domain.model.RiskProfile;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(
        name = "account_limits",
        indexes = {
                @Index(
                        name = "idx_account_limits_account_id",
                        columnList = "account_id"
                ),
                @Index(
                        name = "idx_account_limits_account_type_channel",
                        columnList = "account_id, limit_type, channel",
                        unique = true
                )
        }
)
public class AccountLimitEntity {

    @Id
    @Column(
            name = "limit_id",
            nullable = false,
            updatable = false,
            length = 36
    )
    private String limitId; // identificador persistido do limite

    @Column(
            name = "account_id",
            nullable = false,
            length = 36
    )
    private String accountId; // conta vinculada ao limite

    @Enumerated(EnumType.STRING)
    @Column(
            name = "limit_type",
            nullable = false,
            length = 50
    )
    private LimitType limitType; // tipo de operação controlada

    @Enumerated(EnumType.STRING)
    @Column(
            name = "channel",
            nullable = false,
            length = 50
    )
    private AccountChannel channel; // canal de utilização

    @Enumerated(EnumType.STRING)
    @Column(
            name = "limit_interval",
            nullable = false,
            length = 30
    )
    private LimitInterval limitInterval; // período de avaliação

    @Column(
            name = "configured_amount",
            nullable = false,
            precision = 19,
            scale = 2
    )
    private BigDecimal configuredAmount; // valor máximo configurado

    @Column(
            name = "consumed_amount",
            nullable = false,
            precision = 19,
            scale = 2
    )
    private BigDecimal consumedAmount; // valor já consumido

    @Column(
            name = "available_amount",
            nullable = false,
            precision = 19,
            scale = 2
    )
    private BigDecimal availableAmount; // valor disponível para consumo

    @Enumerated(EnumType.STRING)
    @Column(
            name = "risk_profile",
            nullable = false,
            length = 30
    )
    private RiskProfile riskProfile; // perfil de risco aplicado

    @Column(
            name = "active",
            nullable = false
    )
    private boolean active; // indica se o limite está ativo

    @Column(
            name = "created_at",
            nullable = false,
            updatable = false
    )
    private LocalDateTime createdAt; // data de criação

    @Column(
            name = "updated_at",
            nullable = false
    )
    private LocalDateTime updatedAt; // data da última alteração

    protected AccountLimitEntity() {
    }

    public AccountLimitEntity(
            String limitId,
            String accountId,
            LimitType limitType,
            AccountChannel channel,
            LimitInterval limitInterval,
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
        this.limitInterval = limitInterval;
        this.configuredAmount = configuredAmount;
        this.consumedAmount = consumedAmount;
        this.availableAmount = availableAmount;
        this.riskProfile = riskProfile;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    @PrePersist
    protected void onCreate() {

        LocalDateTime now = LocalDateTime.now();

        this.createdAt = now; // registra criação da configuração

        this.updatedAt = now; // inicializa atualização
    }

    @PreUpdate
    protected void onUpdate() {

        this.updatedAt = LocalDateTime.now(); // atualiza data da configuração
    }

    public String getLimitId() {
        return limitId;
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

    public BigDecimal getConfiguredAmount() {
        return configuredAmount;
    }

    public BigDecimal getConsumedAmount() {
        return consumedAmount;
    }

    public BigDecimal getAvailableAmount() {
        return availableAmount;
    }

    public RiskProfile getRiskProfile() {
        return riskProfile;
    }

    public boolean isActive() {
        return active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}