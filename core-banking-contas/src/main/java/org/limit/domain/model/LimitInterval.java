package com.bank.account.limit.domain.model;

public enum LimitInterval {

    PER_TRANSACTION, // limite aplicado individualmente a cada operação

    HOURLY, // limite acumulado dentro de uma hora

    DAILY, // limite acumulado durante o dia

    WEEKLY, // limite acumulado durante a semana

    MONTHLY, // limite acumulado durante o mês

    CUSTOM // intervalo configurável conforme regra de negócio
}