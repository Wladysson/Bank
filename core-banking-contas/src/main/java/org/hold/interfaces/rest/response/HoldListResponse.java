package com.bank.account.hold.interfaces.rest.response;

import com.bank.account.hold.application.dto.HoldResponseDTO;

import java.util.ArrayList;
import java.util.List;

public class HoldListResponse {

    private List<HoldResponseDTO> holds = new ArrayList<>(); // lista de reservas da conta

    private int totalItems; // quantidade total de reservas

    public HoldListResponse() {
    }

    public HoldListResponse(
            List<HoldResponseDTO> holds
    ) {

        this.holds = holds;
        this.totalItems = holds != null ? holds.size() : 0; // calcula quantidade de registros
    }

    public List<HoldResponseDTO> getHolds() {
        return holds;
    }

    public void setHolds(
            List<HoldResponseDTO> holds
    ) {

        this.holds = holds;
        this.totalItems = holds != null ? holds.size() : 0; // atualiza quantidade ao alterar a lista
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