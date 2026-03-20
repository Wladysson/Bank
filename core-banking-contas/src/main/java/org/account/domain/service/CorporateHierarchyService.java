package com.bank.account.domain.service;

import com.bank.account.domain.model.CorporateHierarchy;
import com.bank.account.domain.repository.CorporateHierarchyRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class CorporateHierarchyService {

    @Inject
    CorporateHierarchyRepository repository;

    public CorporateHierarchy linkAccounts(UUID parentId, UUID childId, int level) {
        CorporateHierarchy hierarchy = new CorporateHierarchy(parentId, childId, level);
        return repository.save(hierarchy);
    }

    public List<CorporateHierarchy> getChildren(UUID parentId) {
        return repository.findByParentAccountId(parentId);
    }

    public List<CorporateHierarchy> getParents(UUID childId) {
        return repository.findByChildAccountId(childId);
    }

    public void unlink(UUID childId) {
        repository.deleteByChildAccountId(childId);
    }
}