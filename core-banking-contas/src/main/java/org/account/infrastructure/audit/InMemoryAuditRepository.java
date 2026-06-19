package com.bank.account.infrastructure.audit;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class InMemoryAuditRepository implements AuditRepository {

    private final List<AuditRecord> records = new ArrayList<>();

    @Override
    public void save(AuditRecord record) {
        records.add(record);
    }

    @Override
    public List<AuditRecord> findByAggregateId(
            String aggregateId
    ) {

        return records.stream()
                .filter(record ->
                        aggregateId.equals(
                                record.getAccountId()
                        )
                )
                .collect(Collectors.toList());
    }

    @Override
    public List<AuditRecord> findByActorId(
            String actorId
    ) {

        return records.stream()
                .filter(record ->
                        actorId.equals(
                                record.getActorId()
                        )
                )
                .collect(Collectors.toList());
    }
}