package com.bank.payments.infrastructure.persistence.repository;

import com.bank.payments.domain.model.PixPayment;
import com.bank.payments.domain.model.PixStatus;
import com.bank.payments.domain.repository.PixRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.OffsetDateTime;
import java.util.*;

@ApplicationScoped
public class PixRepositoryImpl implements PixRepository {

    private final Map<UUID, PixPayment> storage = new HashMap<>();

    @Override
    public PixPayment save(PixPayment pixPayment) {
        storage.put(pixPayment.getId(), pixPayment);
        return pixPayment;
    }

    @Override
    public PixPayment update(PixPayment pixPayment) {
        storage.put(pixPayment.getId(), pixPayment);
        return pixPayment;
    }

    @Override
    public Optional<PixPayment> findById(UUID id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public Optional<PixPayment> findByTxId(String txId) {
        return storage.values().stream()
                .filter(p -> txId.equals(p.getTxId()))
                .findFirst();
    }

    @Override
    public Optional<PixPayment> findByEndToEndId(String endToEndId) {
        return storage.values().stream()
                .filter(p -> endToEndId.equals(p.getEndToEndId()))
                .findFirst();
    }

    @Override
    public List<PixPayment> findByStatus(PixStatus status) {
        return storage.values().stream()
                .filter(p -> p.getStatus() == status)
                .toList();
    }

    @Override
    public List<PixPayment> findByPayerDocument(String payerDocument) {
        return storage.values().stream()
                .filter(p -> payerDocument.equals(p.getPayerDocument()))
                .toList();
    }

    @Override
    public List<PixPayment> findByReceiverKey(String receiverKey) {
        return storage.values().stream()
                .filter(p -> receiverKey.equals(p.getReceiverKey().getValue()))
                .toList();
    }

    @Override
    public List<PixPayment> findCreatedBetween(OffsetDateTime start, OffsetDateTime end) {
        return storage.values().stream()
                .filter(p -> !p.getCreatedAt().isBefore(start) &&
                        !p.getCreatedAt().isAfter(end))
                .toList();
    }

    @Override
    public boolean existsByTxId(String txId) {
        return findByTxId(txId).isPresent();
    }

    @Override
    public boolean existsByEndToEndId(String endToEndId) {
        return findByEndToEndId(endToEndId).isPresent();
    }

    @Override
    public void deleteById(UUID id) {
        storage.remove(id);
    }
}