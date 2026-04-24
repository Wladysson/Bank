package com.bank.payments.infrastructure.persistence.mapper;

import com.bank.payments.domain.model.Payment;
import com.bank.payments.infrastructure.persistence.entity.PaymentEntity;

public class PaymentEntityMapper {

    public static PaymentEntity toEntity(Payment payment) {
        PaymentEntity entity = new PaymentEntity();
        entity.setId(payment.getId());
        entity.setPayerId(payment.getPayerId());
        entity.setPayeeId(payment.getPayeeId());
        entity.setAmount(payment.getAmount());
        entity.setCurrency(payment.getCurrency());
        entity.setStatus(payment.getStatus());
        entity.setDescription(payment.getDescription());
        return entity;
    }

    public static Payment toDomain(PaymentEntity entity) {
        // simplificado (depois melhora)
        return null;
    }
}