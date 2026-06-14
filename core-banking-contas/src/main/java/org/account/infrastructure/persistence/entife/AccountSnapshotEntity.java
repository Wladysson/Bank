package com.bank.account.infrastructure.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(
        name = "account_snapshots",
        indexes = {
                @Index(name = "idx_snapshot_account_id", columnList = "account_id"),
                @Index(name = "idx_snapshot_created_at", columnList = "created_at")
        }
)
public class AccountSnapshotEntity {

    @Id
    @Column(name = "snapshot_id", nullable = false)
    private UUID snapshotId;

    @Column(name = "account_id", nullable = false)
    private String accountId;

    @Column(name = "account_number", nullable = false)
    private String accountNumber;

    @Column(name = "account_status", nullable = false)
    private String accountStatus;

    @Column(name = "account_type", nullable = false)
    private String accountType;

    @Column(name = "snapshot_payload", nullable = false, length = 10000)
    private String payload;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    public UUID getSnapshotId() {
        return snapshotId; // retorna identificador do snapshot
    }

    public void setSnapshotId(UUID snapshotId) {
        this.snapshotId = snapshotId; // define identificador do snapshot
    }

    public String getAccountId() {
        return accountId; // retorna identificador da conta
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId; // define identificador da conta
    }

    public String getAccountNumber() {
        return accountNumber; // retorna número da conta
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber; // define número da conta
    }

    public String getAccountStatus() {
        return accountStatus; // retorna status registrado
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus; // define status registrado
    }

    public String getAccountType() {
        return accountType; // retorna tipo registrado
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType; // define tipo registrado
    }

    public String getPayload() {
        return payload; // retorna estado serializado da conta
    }

    public void setPayload(String payload) {
        this.payload = payload; // define estado serializado da conta
    }

    public Instant getCreatedAt() {
        return createdAt; // retorna data de geração do snapshot
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt; // define data de geração do snapshot
    }
}