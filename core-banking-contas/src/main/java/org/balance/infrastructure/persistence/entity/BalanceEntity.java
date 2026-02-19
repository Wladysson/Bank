package com.bank.account.infrastructure.persistence.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "balances")
public class BalanceEntity {

    @Id
    private UUID id;

    @Column(unique = true)
    private UUID accountId;

    private BigDecimal availableBalance;
    private BigDecimal currentBalance;

    // getters and setters
}