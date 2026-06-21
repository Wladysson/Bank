package com.bank.account.hold.domain.model;

public enum HoldStatus {

    ACTIVE, // reserva criada e impactando o saldo disponível

    RELEASED, // reserva liberada e valor devolvido ao disponível

    EXPIRED, // reserva expirada por tempo limite

    CANCELLED, // reserva cancelada manualmente

    CONSUMED // reserva utilizada na liquidação da operação
}