package com.ddd_bootcamp.threetier.controller.viewModel;

public class AccountRequest {

    private AddressRequest addressRequest;

    public AccountRequest() {
    }

    public AddressRequest getAddressRequest() {
        return addressRequest;
    }

    public void setAddressRequest(AddressRequest addressRequest) {
        this.addressRequest = addressRequest;
    }

    @Override
    public String toString() {
        return "AccountRequest{}";
    }
}
