package com.bank.payments.infrastructure.persistence.repository;

import com.bank.payments.domain.model.Payment;
import com.bank.payments.domain.repository.PaymentRepository;
import com.bank.payments.infrastructure.persistence.entity.PaymentEntity;
import com.bank.payments.infrastructure.persistence.mapper.PaymentEntityMapper;
import com.bank.payments.domain.model.PaymentStatus;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;

@ApplicationScoped
public class PaymentRepositoryImpl implements PaymentRepository {

    @Inject
    EntityManager em;

    @Override
    @Transactional
    public void save(Payment payment) {
        PaymentEntity entity = PaymentEntityMapper.toEntity(payment);
        em.persist(entity);
    }

    @Override
    public Optional<Payment> findById(String paymentId) {
        PaymentEntity entity = em.find(PaymentEntity.class, paymentId);
        return Optional.ofNullable(entity).map(PaymentEntityMapper::toDomain);
    }

    @Override
    public Optional<Payment> findByExternalReference(String externalReference) {
        return em.createQuery(
                        "FROM PaymentEntity p WHERE p.externalReference = :ref", PaymentEntity.class)
                .setParameter("ref", externalReference)
                .getResultStream()
                .findFirst()
                .map(PaymentEntityMapper::toDomain);
    }

    @Override
    public List<Payment> findAll() {
        return em.createQuery("SELECT p FROM PaymentEntity p", PaymentEntity.class)
                .getResultList()
                .stream()
                .map(PaymentEntityMapper::toDomain)
                .toList();
    }

    @Override
    public List<Payment> findByStatus(PaymentStatus status, int limit) {
        return em.createQuery(
                        "SELECT p FROM PaymentEntity p WHERE p.status = :status",
                        PaymentEntity.class
                )
                .setParameter("status", status)
                .setMaxResults(limit)
                .getResultList()
                .stream()
                .map(PaymentEntityMapper::toDomain)
                .toList();
    }

    @Override
    public List<Payment> findProcessingOlderThan(LocalDateTime threshold) {
        return em.createQuery(
                        "SELECT p FROM PaymentEntity p " +
                                "WHERE p.status = :status AND p.createdAt < :threshold",
                        PaymentEntity.class
                )
                .setParameter("status", PaymentStatus.PROCESSING)
                .setParameter("threshold", threshold)
                .getResultList()
                .stream()
                .map(PaymentEntityMapper::toDomain)
                .toList();
    }

    @Override
    @Transactional
    public void update(Payment payment) {
        PaymentEntity entity = PaymentEntityMapper.toEntity(payment);
        em.merge(entity);
    }
}