package com.bank.account.balance.infrastructure.cache;

import com.bank.account.balance.application.dto.AvailableBalanceDTO;

import java.util.Optional;

public interface BalanceCacheRepository {

    Optional<AvailableBalanceDTO> findAvailableBalanceByAccountId(
            String accountId
    ); // consulta saldo disponível em cache

    void save(
            AvailableBalanceDTO availableBalance
    ); // armazena saldo disponível em cache

    void evict(
            String accountId
    ); // remove registro do cache

    boolean exists(
            String accountId
    ); // verifica existência da chave em cache

    void refresh(
            AvailableBalanceDTO availableBalance
    ); // atualiza snapshot de saldo disponível
}