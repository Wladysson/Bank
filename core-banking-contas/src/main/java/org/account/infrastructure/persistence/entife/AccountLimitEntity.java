package com.bank.account.infrastructure.persistence.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "account_limits")
public class AccountLimitEntity {

    @Id
    private UUID id;

    @Column(unique = true)
    private UUID accountId;

    private BigDecimal dailyTransferLimit;
    private BigDecimal dailyWithdrawLimit;
    private BigDecimal monthlyTransferLimit;

    // getters and setters
}