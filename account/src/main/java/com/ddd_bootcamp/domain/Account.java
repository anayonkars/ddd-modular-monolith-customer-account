package com.ddd_bootcamp.domain;

import java.util.UUID;

//Account Aggregate
public class Account implements Aggregate {

    private final CustomerId customerId;
    private AccountId accountId;
    private Address address;

    public Account(Address address, CustomerId customerId) {
        this.accountId = new AccountId(UUID.randomUUID());
        this.address = address;
        this.customerId = customerId;
    }

    public void updateAddress(Address address) {
        this.address = address;
    }

    public AccountId getAccountId() {
        return accountId;
    }

    public Address getAddress() {
        return address;
    }

    public CustomerId getCustomerId() {
        return customerId;
    }

    public String getCustomerIdAsString() {
        return customerId.getCustomerId().toString();
    }

    public String getAccountIdAsString() {
        return  accountId.getAccountIdUUID().toString();
    }

    @Override
    public String toString() {
        return "Account{" +
                "customerId=" + customerId +
                ", accountId=" + accountId +
                ", address=" + address +
                '}';
    }



}
