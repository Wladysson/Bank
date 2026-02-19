package com.bank.account.infrastructure.persistence.repository;

import com.bank.account.domain.model.CorporateHierarchy;
import com.bank.account.domain.repository.CorporateHierarchyRepository;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class JpaCorporateHierarchyRepository implements CorporateHierarchyRepository {

    @Override
    public CorporateHierarchy save(CorporateHierarchy hierarchy) {
        return hierarchy;
    }

    @Override
    public List<CorporateHierarchy> findByParentAccountId(UUID parentAccountId) {
        return List.of();
    }

    @Override
    public List<CorporateHierarchy> findByChildAccountId(UUID childAccountId) {
        return List.of();
    }

    @Override
    public void deleteByChildAccountId(UUID childAccountId) {
    }
}