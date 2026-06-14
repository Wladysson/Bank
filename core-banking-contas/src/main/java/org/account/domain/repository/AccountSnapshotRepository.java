package com.bank.account.account.domain.repository;

import com.bank.account.account.domain.model.AccountId;
import com.bank.account.domain.model.AccountSnapshot;

import java.util.List;
import java.util.Optional;

public interface AccountSnapshotRepository {

     //Salva um snapshot do estado atual da conta
    AccountSnapshot save(AccountSnapshot snapshot); // persiste estado congelado da conta

     //Busca um snapshot específico pelo identificador
    Optional<AccountSnapshot> findByAccountId(AccountId accountId); // recupera snapshot atual ou último

    //Lista histórico de snapshots de uma conta
    List<AccountSnapshot> findHistoryByAccountId(AccountId accountId); // histórico de estados da conta
}