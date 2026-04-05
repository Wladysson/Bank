package com.bank.ledger.domain.event;

public interface DomainEventPublisher {

    void publish(Object event);

}