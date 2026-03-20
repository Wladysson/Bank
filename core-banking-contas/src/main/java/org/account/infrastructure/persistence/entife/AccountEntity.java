package com.bank.account.infrastructure.persistence.entity;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "accounts")
public class AccountEntity {

    @Id
    private UUID id;

    @Column(unique = true, nullable = false)
    private String accountNumber;

    @Enumerated(EnumType.STRING)
    private String accountType;

    @Enumerated(EnumType.STRING)
    private String status;

    private UUID primaryHolderId;

    private Instant createdAt;
    private Instant updatedAt;

    // getters and setters
}