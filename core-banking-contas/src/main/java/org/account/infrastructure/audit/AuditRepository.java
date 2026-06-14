package com.bank.account.infrastructure.audit;

import java.util.List;

public interface AuditRepository {

    void save(AuditRecord record); // persiste um registro de auditoria

    List<AuditRecord> findByAggregateId(String aggregateId); // busca registros por ID da conta

    List<AuditRecord> findByActorId(String actorId); // busca registros por usuário/sistema
}
