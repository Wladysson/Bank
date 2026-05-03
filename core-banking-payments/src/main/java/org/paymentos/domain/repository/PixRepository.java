package com.bank.payments.domain.repository;

import com.bank.payments.domain.model.PixPayment;
import com.bank.payments.domain.model.PixStatus;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PixRepository {

    PixPayment save(PixPayment pixPayment);

    PixPayment update(PixPayment pixPayment);

    Optional<PixPayment> findById(UUID id);

    Optional<PixPayment> findByTxId(String txId);

    Optional<PixPayment> findByEndToEndId(String endToEndId);

    List<PixPayment> findByStatus(PixStatus status);

    List<PixPayment> findByPayerDocument(String payerDocument);

    List<PixPayment> findByReceiverKey(String receiverKey);

    List<PixPayment> findCreatedBetween(OffsetDateTime start, OffsetDateTime end);

    boolean existsByTxId(String txId);

    boolean existsByEndToEndId(String endToEndId);

    void deleteById(UUID id);
}
