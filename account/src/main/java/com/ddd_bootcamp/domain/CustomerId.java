package com.ddd_bootcamp.domain;

import java.util.UUID;

public class CustomerId {

    private UUID customerId;

    public CustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    @Override
    public String toString() {
        return "CustomerId{" +
                "customerId=" + customerId +
                '}';
    }
}
