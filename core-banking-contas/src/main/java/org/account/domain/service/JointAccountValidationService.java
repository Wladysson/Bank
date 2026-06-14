package com.bank.account.domain.service;

import com.bank.account.domain.model.CustomerId;

import java.util.HashSet;
import java.util.Set;

 //Service responsável por validar regras de contas conjuntas
 //Garante integridade dos titulares e evita inconsistências no vínculo multi-titular

public final class JointAccountValidationService {

    //Valida se os titulares podem compor uma conta conjunta

    public void validate(Set<CustomerId> holders) {
        if (holders == null || holders.isEmpty()) { // valida existência de titulares
            throw new IllegalArgumentException("Joint account must have at least one holder");
        }

        if (holders.size() < 2) { // regra de negócio: conta conjunta exige múltiplos titulares
            throw new IllegalArgumentException("Joint account must have at least two holders");
        }

        if (hasDuplicates(holders)) { // garante unicidade de titulares
            throw new IllegalArgumentException("Duplicate holders are not allowed in joint account");
        }
    }

     //Verifica duplicidade de titulares
    private boolean hasDuplicates(Set<CustomerId> holders) {
        return new HashSet<>(holders).size() != holders.size(); // comparação de integridade
    }
}