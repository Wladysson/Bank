package com.bank.account.limit.domain.repository;

import com.bank.account.limit.domain.model.AccountLimit;
import com.bank.account.limit.domain.model.AccountChannel;
import com.bank.account.limit.domain.model.LimitType;

import java.util.List;
import java.util.Optional;

public interface AccountLimitRepository {

    AccountLimit save(
            AccountLimit accountLimit
    ); // persiste ou atualiza a configuração de limite

    Optional<AccountLimit> findById(
            String limitId
    ); // busca um limite pelo identificador

    Optional<AccountLimit> findByAccountIdAndTypeAndChannel(
            String accountId,
            LimitType limitType,
            AccountChannel channel
    ); // busca limite específico da conta, operação e canal

    List<AccountLimit> findByAccountId(
            String accountId
    ); // retorna todos os limites configurados para uma conta

    void delete(
            AccountLimit accountLimit
    ); // remove uma configuração de limite

    boolean existsByAccountIdAndTypeAndChannel(
            String accountId,
            LimitType limitType,
            AccountChannel channel
    ); // verifica se já existe limite para a combinação informada
}