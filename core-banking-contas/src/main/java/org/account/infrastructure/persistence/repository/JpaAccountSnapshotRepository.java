package com.bank.account.infrastructure.persistence.repository;

import com.bank.account.infrastructure.persistence.entity.AccountSnapshotEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class JpaAccountSnapshotRepository {

    @Inject
    EntityManager em;

    public Optional<AccountSnapshotEntity> findFirstByAccountIdOrderByCreatedAtDesc(
            String accountId
    ) {
        return em.createQuery(
                "SELECT a FROM AccountSnapshotEntity a WHERE a.accountId = :accountId ORDER BY a.createdAt DESC",
                AccountSnapshotEntity.class
        )
                .setParameter("accountId", accountId)
                .setMaxResults(1)
                .getResultStream()
                .findFirst(); // busca snapshot mais recente da conta
    }

    public List<AccountSnapshotEntity> findByAccountIdOrderByCreatedAtDesc(
            String accountId
    ) {
        return em.createQuery(
                "SELECT a FROM AccountSnapshotEntity a WHERE a.accountId = :accountId ORDER BY a.createdAt DESC",
                AccountSnapshotEntity.class
        )
                .setParameter("accountId", accountId)
                .getResultList(); // busca histórico completo da conta
    }

    public void deleteByAccountId(
            String accountId
    ) {
        em.createQuery(
                "DELETE FROM AccountSnapshotEntity a WHERE a.accountId = :accountId"
        )
                .setParameter("accountId", accountId)
                .executeUpdate(); // remove snapshots vinculados à conta
    }

    public void save(AccountSnapshotEntity entity) {
        em.persist(entity);
    }
}