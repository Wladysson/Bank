package com.bank.payments.application.usecase.boleto;

import com.bank.payments.domain.model.Boleto;
import com.bank.payments.domain.repository.BoletoRepository;
import com.bank.payments.infrastructure.pdf.BoletoPdfGenerator;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class GetBoletoPdfUseCase {

    @Inject
    BoletoRepository repository;

    @Inject
    BoletoPdfGenerator pdfGenerator;

    public byte[] execute(String id) {
        Boleto boleto = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Boleto não encontrado: " + id));

        return pdfGenerator.generate(boleto);
    }
}