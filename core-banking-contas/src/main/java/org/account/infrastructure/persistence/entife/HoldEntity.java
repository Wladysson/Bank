package com.bank.account.infrastructure.persistence.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "holds")
public class HoldEntity {

    @Id
    private UUID id;

    private UUID accountId;

    private BigDecimal amount;

    private String status;

    private Instant createdAt;
    private Instant releasedAt;

    // getters and setters
}