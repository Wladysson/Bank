package com.bank.transactions.infrastructure.integration.receipt;

import com.bank.transactions.domain.gateway.receipt.ReceiptStorageGateway;
import com.bank.transactions.domain.model.common.Receipt;
import jakarta.enterprise.context.ApplicationScoped;

// Implementação do gateway de armazenamento de comprovantes
@ApplicationScoped
public class ReceiptStorageGatewayImpl
        implements ReceiptStorageGateway {

    // Armazena comprovante gerado
    @Override
    public String store(Receipt receipt) {

        // Simula URL do comprovante armazenado
        return String.format(
                "https://storage.seubanco.com/receipts/%s.pdf",
                receipt.getReceiptId()
        );
    }

    // Busca comprovante armazenado
    @Override
    public Receipt findByReceiptId(String receiptId) {

        Receipt receipt = new Receipt();

        receipt.setReceiptId(receiptId);

        receipt.setReceiptUrl(
                "https://storage.seubanco.com/receipts/"
                        + receiptId
                        + ".pdf"
        );

        return receipt;
    }

    // Remove comprovante armazenado
    @Override
    public void delete(String receiptId) {

        // Simulação de remoção no storage
        System.out.println(
                "Comprovante removido: " + receiptId
        );
    }
}