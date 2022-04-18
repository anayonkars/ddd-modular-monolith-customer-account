package com.ddd_bootcamp.threetier.controller.viewModel;

public class AccountRequest {

    private AddressRequest addressRequest;
    private String customerId;

    public AccountRequest() {
    }

    public AddressRequest getAddressRequest() {
        return addressRequest;
    }

    public void setAddressRequest(AddressRequest addressRequest) {
        this.addressRequest = addressRequest;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "AccountRequest{" +
                "addressRequest=" + addressRequest +
                ", customerId='" + customerId + '\'' +
                '}';
    }
}
