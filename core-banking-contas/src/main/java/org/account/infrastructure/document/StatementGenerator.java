package com.bank.account.infrastructure.document;

import com.bank.account.domain.model.Statement;

import jakarta.enterprise.context.ApplicationScoped;

import java.time.format.DateTimeFormatter;

@ApplicationScoped
public class StatementGenerator {

    public String generate(Statement statement) {

        StringBuilder sb = new StringBuilder();

        sb.append("==== EXTRATO BANCÁRIO ====\n");
        sb.append("Conta: ").append(statement.getAccountId()).append("\n\n");

        DateTimeFormatter formatter = DateTimeFormatter.ISO_INSTANT;

        statement.getTransactions().forEach(tx -> {
            sb.append("Data: ").append(formatter.format(tx.getTimestamp())).append("\n");
            sb.append("Tipo: ").append(tx.getType()).append("\n");
            sb.append("Valor: ").append(tx.getAmount()).append("\n");
            sb.append("Saldo após: ").append(tx.getBalanceAfter()).append("\n");
            sb.append("Descrição: ").append(tx.getDescription()).append("\n");
            sb.append("----------------------------\n");
        });

        return sb.toString();
    }
}