package com.bank.account.infrastructure.document;

import com.bank.account.domain.model.Statement;

import jakarta.enterprise.context.ApplicationScoped;

import java.math.BigDecimal;

@ApplicationScoped
public class IncomeReportGenerator {

    public String generate(Statement statement) {

        BigDecimal totalCredits = BigDecimal.ZERO;
        BigDecimal totalDebits = BigDecimal.ZERO;

        for (Statement.Transaction tx : statement.getTransactions()) {

            switch (tx.getType()) {
                case DEPOSIT, TRANSFER -> totalCredits = totalCredits.add(tx.getAmount());
                case WITHDRAW -> totalDebits = totalDebits.add(tx.getAmount());
                default -> {}
            }
        }

        StringBuilder sb = new StringBuilder();

        sb.append("==== RELATÓRIO FINANCEIRO ====\n\n");
        sb.append("Conta: ").append(statement.getAccountId()).append("\n\n");

        sb.append("Total de Créditos: ").append(totalCredits).append("\n");
        sb.append("Total de Débitos: ").append(totalDebits).append("\n");

        sb.append("Saldo Líquido: ").append(totalCredits.subtract(totalDebits)).append("\n");

        return sb.toString();
    }
}