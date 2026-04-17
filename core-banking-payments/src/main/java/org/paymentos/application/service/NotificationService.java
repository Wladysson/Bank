package com.bank.payments.application.service;

import com.bank.payments.domain.model.Payment;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class NotificationService {

    public void notifySuccess(Payment payment) {}

    public void notifyRefund(Payment payment) {}
}