package com.bank.account.limit.infrastructure.persistence.repository;

import com.bank.account.limit.domain.model.AccountChannel;
import com.bank.account.limit.domain.model.AccountLimit;
import com.bank.account.limit.domain.model.LimitType;
import com.bank.account.limit.infrastructure.persistence.entity.AccountLimitEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class JpaAccountLimitRepository {

    private final EntityManager entityManager;

    public JpaAccountLimitRepository(
            EntityManager entityManager
    ) {
        this.entityManager = entityManager;
    }

    @Transactional
    public AccountLimitEntity save(
            AccountLimitEntity entity
    ) {

        if (entityManager.find(
                AccountLimitEntity.class,
                entity.getLimitId()
        ) == null) {

            entityManager.persist(entity); // cria novo limite

            return entity;
        }

        return entityManager.merge(entity); // atualiza limite existente
    }

    public Optional<AccountLimitEntity> findById(
            String limitId
    ) {

        return Optional.ofNullable(
                entityManager.find(
                        AccountLimitEntity.class,
                        limitId
                )
        ); // busca limite pelo identificador
    }

    public Optional<AccountLimitEntity> findByAccountIdAndTypeAndChannel(
            String accountId,
            LimitType limitType,
            AccountChannel channel
    ) {

        try {

            AccountLimitEntity entity = entityManager
                    .createQuery(
                            """
                            SELECT a
                            FROM AccountLimitEntity a
                            WHERE a.accountId = :accountId
                              AND a.limitType = :limitType
                              AND a.channel = :channel
                            """,
                            AccountLimitEntity.class
                    )
                    .setParameter("accountId", accountId)
                    .setParameter("limitType", limitType)
                    .setParameter("channel", channel)
                    .getSingleResult();

            return Optional.of(entity);

        } catch (NoResultException exception) {

            return Optional.empty(); // nenhuma configuração encontrada
        }
    }

    public List<AccountLimitEntity> findByAccountId(
            String accountId
    ) {

        return entityManager
                .createQuery(
                        """
                        SELECT a
                        FROM AccountLimitEntity a
                        WHERE a.accountId = :accountId
                        ORDER BY a.limitType, a.channel
                        """,
                        AccountLimitEntity.class
                )
                .setParameter("accountId", accountId)
                .getResultList(); // retorna todos os limites da conta
    }

    @Transactional
    public void delete(
            AccountLimitEntity entity
    ) {

        AccountLimitEntity managedEntity =
                entityManager.contains(entity)
                        ? entity
                        : entityManager.merge(entity);

        entityManager.remove(managedEntity); // remove a configuração persistida
    }

    public boolean existsByAccountIdAndTypeAndChannel(
            String accountId,
            LimitType limitType,
            AccountChannel channel
    ) {

        Long count = entityManager
                .createQuery(
                        """
                        SELECT COUNT(a)
                        FROM AccountLimitEntity a
                        WHERE a.accountId = :accountId
                          AND a.limitType = :limitType
                          AND a.channel = :channel
                        """,
                        Long.class
                )
                .setParameter("accountId", accountId)
                .setParameter("limitType", limitType)
                .setParameter("channel", channel)
                .getSingleResult();

        return count > 0; // verifica existência da configuração
    }
}