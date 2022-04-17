package com.ddd_bootcamp.domain.events;

import com.ddd_bootcamp.domain.Address;

import java.util.UUID;


public class CustomerAddressUpdatedEvent implements DomainEvent {
    private UUID customerId;
    private Address address;


    public CustomerAddressUpdatedEvent(UUID customerId, Address address) {
        this.customerId = customerId;
        this.address = address;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public Address getAddress() {
        return address;
    }
}