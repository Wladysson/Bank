package com.bank.payments.infrastructure.persistence.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "subscriptions")
public class SubscriptionEntity {

    @Id
    private String id;

    private String userId;
    private String merchantId;

    private BigDecimal amount;
    private String currency;

    private String frequency;
    private LocalDate nextExecutionDate;

    private boolean active;

    // getters e setters
}