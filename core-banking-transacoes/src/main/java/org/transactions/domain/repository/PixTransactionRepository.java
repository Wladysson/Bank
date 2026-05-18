package com.bank.transactions.domain.repository;

import com.bank.transactions.domain.model.pix.PixTransaction;
import com.bank.transactions.domain.model.pix.PixTransactionStatus;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PixTransactionRepository {

    PixTransaction save(PixTransaction transaction);

    Optional<PixTransaction> findById(UUID id);

    Optional<PixTransaction> findByEndToEndId(String endToEndId);

    List<PixTransaction> findByStatus(PixTransactionStatus status);

    List<PixTransaction> findByAccountId(String accountId);

    List<PixTransaction> findByPixKey(String pixKey);

    List<PixTransaction> findCreatedBetween(
            OffsetDateTime start,
            OffsetDateTime end
    );

    boolean existsByEndToEndId(String endToEndId);

    boolean existsById(UUID id);
}