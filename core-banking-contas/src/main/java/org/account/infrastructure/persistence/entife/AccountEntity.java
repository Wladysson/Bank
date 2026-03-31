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

    private String accountType;
    private String status;

    private UUID primaryHolderId;

    private Instant createdAt;
    private Instant updatedAt;

    // GETTERS
    public UUID getId() { return id; }
    public String getAccountNumber() { return accountNumber; }
    public String getAccountType() { return accountType; }
    public String getStatus() { return status; }
    public UUID getPrimaryHolderId() { return primaryHolderId; }

    // SETTERS
    public void setId(UUID id) { this.id = id; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }
    public void setAccountType(String accountType) { this.accountType = accountType; }
    public void setStatus(String status) { this.status = status; }
    public void setPrimaryHolderId(UUID primaryHolderId) { this.primaryHolderId = primaryHolderId; }
}
