package com.bank.payments.application.usecase.boleto;

import com.bank.payments.domain.model.Boleto;
import com.bank.payments.domain.repository.BoletoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class GetBoletoUseCase {

    @Inject
    BoletoRepository repository;

    public Boleto execute(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Boleto não encontrado: " + id));
    }
}
