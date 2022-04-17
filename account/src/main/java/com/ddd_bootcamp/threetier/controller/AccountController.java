package com.ddd_bootcamp.threetier.controller;

import com.ddd_bootcamp.domain.Account;
import com.ddd_bootcamp.domain.Address;
import com.ddd_bootcamp.domain.CustomerId;
import com.ddd_bootcamp.threetier.applicationservice.AccountAppService;
import com.ddd_bootcamp.threetier.controller.resource.AccountResource;
import com.ddd_bootcamp.threetier.controller.viewModel.AccountRequest;
import com.ddd_bootcamp.threetier.controller.viewModel.AddressRequest;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class AccountController {

    private final AccountAppService accountAppService;

    public AccountController(AccountAppService accountAppService) {
        this.accountAppService = accountAppService;
    }

    @PostMapping("/accounts/{customerId}")
    public AccountResource create(@RequestBody AccountRequest request, @PathVariable String customerId) {
        System.out.println("request = " + request);

        Account account = accountAppService.createAccount(
                new Account(new Address(request.getAddressRequest().getCity()),
                        new CustomerId(UUID.fromString(customerId))));

        return AccountResource.from(account);
    }

    @PutMapping("/accounts/{accountId}/address")
    public AccountResource updateAddress(@RequestBody AddressRequest request, @PathVariable String accountId) {
        System.out.println("request = " + request);
        System.out.println("PathVariable = " + accountId);

        Account account = accountAppService.updateAddress(UUID.fromString(accountId), new Address(request.getCity()));

        return AccountResource.from(account);
    }


}
