package com.bank.payments.infrastructure.messaging.outbox;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class OutboxRepository {

    @Inject
    EntityManager em;

    @Transactional
    public void save(OutboxEntity entity) {
        em.persist(entity);
    }

    public List<OutboxEntity> findUnprocessed() {
        return em.createQuery(
                "FROM OutboxEntity o WHERE o.processed = false",
                OutboxEntity.class
        ).getResultList();
    }

    @Transactional
    public void markAsProcessed(Long id) {
        OutboxEntity entity = em.find(OutboxEntity.class, id);
        if (entity != null) {
            entity.setProcessed(true);
        }
    }
}