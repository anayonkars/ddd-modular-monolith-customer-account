package com.ddd_bootcamp.threetier.controller.resource;

import com.ddd_bootcamp.domain.Account;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class AccountResource {
    private String accountId;
    private AddressData addressData;

    public AccountResource() {
    }

    public static AccountResource from(Account account) {
        AccountResource accountResource = new AccountResource();
        accountResource.setAccountId(account.getAccountIdAsString());

        accountResource.setAddressData(AddressData.from(account.getAddress()));
        return accountResource;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public AddressData getAddressData() {
        return addressData;
    }

    public void setAddressData(AddressData addressData) {
        this.addressData = addressData;
    }
}
