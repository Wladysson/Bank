package com.bank.account.domain.model;

import com.bank.account.domain.model.AccountId;
import com.bank.account.domain.model.AccountNumber;
import java.time.Instant;
import java.util.Objects;
import java.util.Optional;
import com.bank.account.domain.model.AccountStatus;

 //Snapshot da conta representando um estado congelado do agregado em um ponto no tempo
 //Usado para auditoria, histórico e reconstrução de estado

public final class AccountSnapshot {

    private final AccountId accountId;
    private final AccountNumber accountNumber;
    private final AccountStatus status;
    private final Instant snapshotAt;

    private AccountSnapshot(
            AccountId accountId,
            AccountNumber accountNumber,
            AccountStatus status,
            Instant snapshotAt
    ) {
        this.accountId = accountId;
        this.accountNumber = accountNumber;
        this.status = status;
        this.snapshotAt = snapshotAt;
    }

    public static AccountSnapshot of(
            AccountId accountId,
            AccountNumber accountNumber,
            AccountStatus status
    ) {
        if (accountId == null || accountNumber == null || status == null) { // valida integridade do snapshot
            throw new IllegalArgumentException("Snapshot fields cannot be null");
        }

        return new AccountSnapshot(
                accountId,
                accountNumber,
                status,
                Instant.now() // registra momento exato do snapshot
        );
    }

    public AccountId getAccountId() {
        return accountId; // identificador da conta no snapshot
    }

    public AccountNumber getAccountNumber() {
        return accountNumber; // número da conta no snapshot
    }

    public AccountStatus getStatus() {
        return status; // status no momento do snapshot
    }

    public Instant getSnapshotAt() {
        return snapshotAt; // timestamp do estado capturado
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // comparação por referência
        if (!(o instanceof AccountSnapshot)) return false;
        AccountSnapshot that = (AccountSnapshot) o;
        return Objects.equals(accountId, that.accountId) &&
                Objects.equals(accountNumber, that.accountNumber) &&
                Objects.equals(status, that.status) &&
                Objects.equals(snapshotAt, that.snapshotAt); // comparação completa do estado
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, accountNumber, status, snapshotAt); // hash do estado congelado
    }

    @Override
    public String toString() {
        return "AccountSnapshot{" +
                "accountId=" + accountId +
                ", accountNumber=" + accountNumber +
                ", status=" + status +
                ", snapshotAt=" + snapshotAt +
                '}'; // representação clara para auditoria
    }
}