package com.bank.account.infrastructure.audit;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import com.bank.account.infrastructure.audit.AuditRecord;

public class AuditEventFactory {

    public AuditRecord createAccountStatusChangedEvent(
            String accountId,
            String previousStatus,
            String currentStatus,
            AuditContext context
    ) {

        Map<String, Object> details = new HashMap<>();

        details.put("previousStatus", previousStatus); // status anterior
        details.put("currentStatus", currentStatus); // status atualizado

        return new AuditRecord(
                accountId,
                "ACCOUNT_STATUS_CHANGED",
                details,
                context.getActorId(),
                context.getCorrelationId(),
                Instant.now()
        );
    }

    public AuditRecord createAccountBlockedEvent(
            String accountId,
            String reason,
            AuditContext context
    ) {

        Map<String, Object> details = new HashMap<>();

        details.put("reason", reason); // motivo do bloqueio

        return new AuditRecord(
                accountId,
                "ACCOUNT_BLOCKED",
                details,
                context.getActorId(),
                context.getCorrelationId(),
                Instant.now()
        );
    }

    public AuditRecord createAccountClosedEvent(
            String accountId,
            String reason,
            AuditContext context
    ) {

        Map<String, Object> details = new HashMap<>();

        details.put("reason", reason); // motivo do encerramento

        return new AuditRecord(
                accountId,
                "ACCOUNT_CLOSED",
                details,
                context.getActorId(),
                context.getCorrelationId(),
                Instant.now()
        );
    }
}