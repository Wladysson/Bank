package com.bank.account.infrastructure.persistence.repository;

import com.bank.account.domain.model.Account;
import com.bank.account.domain.repository.AccountRepository;
import com.bank.account.infrastructure.persistence.entity.AccountEntity;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class JpaAccountRepository implements AccountRepository {

    @Inject
    EntityManager em;

    @Override
    public Account save(Account account) {
        AccountEntity entity = mapToEntity(account);
        em.merge(entity);
        return account;
    }

    @Override
    public Optional<Account> findById(UUID accountId) {
        AccountEntity entity = em.find(AccountEntity.class, accountId);
        return Optional.ofNullable(entity).map(this::mapToDomain);
    }

    @Override
    public Optional<Account> findByAccountNumber(String accountNumber) {
        return em.createQuery(
                        "SELECT a FROM AccountEntity a WHERE a.accountNumber = :num",
                        AccountEntity.class
                ).setParameter("num", accountNumber)
                .getResultStream()
                .findFirst()
                .map(this::mapToDomain);
    }

    @Override
    public boolean existsByAccountNumber(String accountNumber) {
        Long count = em.createQuery(
                        "SELECT COUNT(a) FROM AccountEntity a WHERE a.accountNumber = :num",
                        Long.class
                ).setParameter("num", accountNumber)
                .getSingleResult();

        return count > 0;
    }

    @Override
    public void deleteById(UUID accountId) {
        AccountEntity entity = em.find(AccountEntity.class, accountId);
        if (entity != null) em.remove(entity);
    }

    private AccountEntity mapToEntity(Account account) {
        AccountEntity entity = new AccountEntity();
        entity.setId(account.getAccountId());
        entity.setAccountNumber(account.getAccountNumber());
        entity.setAccountType(account.getType().name());
        entity.setStatus(account.getStatus().name());
        return entity;
    }

    private Account mapToDomain(AccountEntity entity) {
        return Account.open(
                entity.getId(),
                entity.getAccountNumber(),
                Enum.valueOf(
                        com.bank.account.domain.model.AccountType.class,
                        entity.getAccountType()
                )
        );
    }
}