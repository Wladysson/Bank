package com.bank.account.limit.domain.event;

import com.bank.account.limit.domain.model.AccountChannel;
import com.bank.account.limit.domain.model.LimitInterval;
import com.bank.account.limit.domain.model.LimitType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class LimitConfiguredEvent {

    private final String accountId; // identificador da conta que recebeu a configuração

    private final String limitId; // identificador do limite configurado

    private final LimitType limitType; // tipo de operação controlada pelo limite

    private final AccountChannel channel; // canal ao qual o limite se aplica

    private final LimitInterval interval; // período de avaliação do limite

    private final BigDecimal amount; // valor máximo configurado para o limite

    private final LocalDateTime occurredAt; // momento em que o evento ocorreu

    public LimitConfiguredEvent(
            String accountId,
            String limitId,
            LimitType limitType,
            AccountChannel channel,
            LimitInterval interval,
            BigDecimal amount
    ) {
        this.accountId = accountId;
        this.limitId = limitId;
        this.limitType = limitType;
        this.channel = channel;
        this.interval = interval;
        this.amount = amount;
        this.occurredAt = LocalDateTime.now(); // registra o momento da configuração
    }

    public String getAccountId() {
        return accountId;
    }

    public String getLimitId() {
        return limitId;
    }

    public LimitType getLimitType() {
        return limitType;
    }

    public AccountChannel getChannel() {
        return channel;
    }

    public LimitInterval getInterval() {
        return interval;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDateTime getOccurredAt() {
        return occurredAt;
    }
}