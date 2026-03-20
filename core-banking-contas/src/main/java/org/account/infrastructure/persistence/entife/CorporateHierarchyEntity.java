package com.bank.account.infrastructure.persistence.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "corporate_hierarchy")
public class CorporateHierarchyEntity {

    @Id
    private UUID id;

    private UUID parentAccountId;
    private UUID childAccountId;

    private int level;

    // getters and setters
}