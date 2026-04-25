package com.bank.payments.application.usecase.boleto;

import com.bank.payments.domain.model.Boleto;
import com.bank.payments.domain.repository.BoletoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class CancelBoletoUseCase {

    @Inject
    BoletoRepository repository;

    @Transactional
    public Boleto execute(String id) {
        Boleto boleto = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Boleto não encontrado: " + id));

        boleto.cancel();
        repository.save(boleto);

        return boleto;
    }
}