package com.bank.payments.infrastructure.persistence.repository;

import com.bank.payments.domain.model.WebhookSubscription;
import com.bank.payments.domain.repository.WebhookSubscriptionRepository;
import com.bank.payments.infrastructure.persistence.entity.WebhookSubscriptionEntity;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class WebhookSubscriptionRepositoryImpl implements WebhookSubscriptionRepository {

    @Inject
    EntityManager em;

    @Override
    public List<WebhookSubscription> findAll() {
        return em.createQuery("SELECT w FROM WebhookSubscriptionEntity w", WebhookSubscriptionEntity.class)
                .getResultList()
                .stream()
                .map(this::toDomain)
                .toList();
    }

    @Override
    public WebhookSubscription findById(String id) {
        WebhookSubscriptionEntity entity = em.find(WebhookSubscriptionEntity.class, id);
        return entity != null ? toDomain(entity) : null;
    }

    @Override
    @Transactional
    public WebhookSubscription save(WebhookSubscription subscription) {
        WebhookSubscriptionEntity entity = toEntity(subscription);
        em.merge(entity);
        return subscription;
    }

    @Override
    @Transactional
    public void delete(String id) {
        WebhookSubscriptionEntity entity = em.find(WebhookSubscriptionEntity.class, id);
        if (entity != null) {
            em.remove(entity);
        }
    }

    private WebhookSubscription toDomain(WebhookSubscriptionEntity e) {
        return new WebhookSubscription(
                e.getId(),
                e.getUrl(),
                e.getEventType(),
                e.isActive()
        );
    }

    private WebhookSubscriptionEntity toEntity(WebhookSubscription d) {
        WebhookSubscriptionEntity e = new WebhookSubscriptionEntity();
        e.setId(d.getId());
        e.setUrl(d.getUrl());
        e.setEventType(d.getEventType());
        e.setActive(d.isActive());
        return e;
    }
}