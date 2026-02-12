package com.bank.account.domain.repository;

import com.bank.account.domain.model.CorporateHierarchy;

import java.util.List;
import java.util.UUID;

public interface CorporateHierarchyRepository {

    CorporateHierarchy save(CorporateHierarchy hierarchy);

    List<CorporateHierarchy> findByParentAccountId(UUID parentAccountId);

    List<CorporateHierarchy> findByChildAccountId(UUID childAccountId);

    void deleteByChildAccountId(UUID childAccountId);
}