package com.bank.account.limit.interfaces.rest.response;

import com.bank.account.limit.application.dto.LimitConfigurationDTO;

import java.util.ArrayList;
import java.util.List;

public class LimitListResponse {

    private List<LimitConfigurationDTO> limits = new ArrayList<>(); // limites configurados para a conta
    private int totalItems; // quantidade de limites retornados

    public LimitListResponse() {
    }

    public LimitListResponse(
            List<LimitConfigurationDTO> limits
    ) {

        setLimits(limits); // inicializa a lista e atualiza o total
    }

    public List<LimitConfigurationDTO> getLimits() {
        return limits;
    }

    public void setLimits(
            List<LimitConfigurationDTO> limits
    ) {

        this.limits = limits != null
                ? new ArrayList<>(limits)
                : new ArrayList<>(); // evita referência externa à coleção

        this.totalItems = this.limits.size(); // mantém o total sincronizado
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(
            int totalItems
    ) {
        this.totalItems = totalItems;
    }
}