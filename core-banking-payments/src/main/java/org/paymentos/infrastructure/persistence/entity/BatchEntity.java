package com.bank.payments.infrastructure.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "batch_payments")
public class BatchEntity {

    @Id
    private String id;

    private int totalItems;

    // getters e setters
}