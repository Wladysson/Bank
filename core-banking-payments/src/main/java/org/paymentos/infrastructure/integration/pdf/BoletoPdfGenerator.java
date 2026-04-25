package com.bank.payments.infrastructure.pdf;

import com.bank.payments.domain.model.Boleto;
import jakarta.enterprise.context.ApplicationScoped;

import java.nio.charset.StandardCharsets;

@ApplicationScoped
public class BoletoPdfGenerator {

    public byte[] generate(Boleto boleto) {
        String content = """
                ================================
                         BOLETO BANCÁRIO
                ================================
                ID: %s
                Pagador: %s
                Documento: %s
                Valor: %s
                Vencimento: %s
                Código de Barras: %s
                Linha Digitável: %s
                Status: %s
                ================================
                """.formatted(
                boleto.getId(),
                boleto.getPayerName(),
                boleto.getPayerDocument(),
                boleto.getAmount(),
                boleto.getDueDate(),
                boleto.getBarcode(),
                boleto.getDigitableLine(),
                boleto.getStatus().name()
        );

        return content.getBytes(StandardCharsets.UTF_8);
    }
}