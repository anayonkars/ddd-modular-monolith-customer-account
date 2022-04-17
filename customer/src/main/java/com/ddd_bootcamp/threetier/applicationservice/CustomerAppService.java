package com.ddd_bootcamp.threetier.applicationservice;

import com.ddd_bootcamp.domain.AccountId;
import com.ddd_bootcamp.domain.Address;
import com.ddd_bootcamp.domain.Customer;
import com.ddd_bootcamp.threetier.controller.AccountController;
import com.ddd_bootcamp.threetier.controller.viewModel.AddressRequest;
import com.ddd_bootcamp.threetier.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CustomerAppService {

    private CustomerRepository customerRepository;
    private AccountController accountController;

//    @Autowired
//    private RestTemplate restTemplate;

    public CustomerAppService(CustomerRepository customerRepository, AccountController accountController) {

        this.customerRepository = customerRepository;
        this.accountController = accountController;
    }

    //@Transactional
    public Customer createCustomer(Customer customer) {
        Customer savedCustomer = customerRepository.save(customer);
        return savedCustomer;
    }

    //@Transactional
    public Customer updateAddress(UUID customerId, Address address) {
        Customer customer = customerRepository.find(customerId);
        customer.updateAddress(address);
        Customer savedCustomer = customerRepository.save(customer);

        List<String> accountIds = customer.getAccountIds().stream()
                .map(accountId -> accountId.getAccountIdUUID().toString()).collect(Collectors.toList());
        AddressRequest request = new AddressRequest();
        request.setCity(address.getCity());
        accountIds.forEach(accountId ->
//                restTemplate.put("http://localhost:8083/accounts/" + accountId + "/address",
//                        request, AccountResource.class));
                accountController.updateAddress(request, accountId));

        return savedCustomer;
    }

    public Customer addAccount(UUID customerId, String accountId) {
        Customer customer = customerRepository.find(customerId);
        customer.add(new AccountId(UUID.fromString(accountId)));
        customerRepository.save(customer);
        return customer;
    }

}
