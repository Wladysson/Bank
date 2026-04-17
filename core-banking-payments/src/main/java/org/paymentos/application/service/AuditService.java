package com.bank.payments.application.service;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AuditService {

    public void log(String action, String reference) {
        // log simples por enquanto
        System.out.println(action + " - " + reference);
    }
}