package com.bank.account.limit.domain.model;

public enum RiskProfile {

    LOW, // perfil de baixo risco com maior elegibilidade operacional

    MEDIUM, // perfil de risco intermediário

    HIGH, // perfil de maior risco sujeito a restrições adicionais

    VERY_HIGH, // perfil crítico com controles mais rigorosos

    RESTRICTED // perfil com operações severamente limitadas
}