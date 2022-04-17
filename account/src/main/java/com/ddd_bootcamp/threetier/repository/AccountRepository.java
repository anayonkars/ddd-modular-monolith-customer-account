package com.ddd_bootcamp.threetier.repository;

import com.ddd_bootcamp.domain.Account;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

//Account Repository or Data Access Layer
//Using in-memory map instead of db for demo

@Repository
public class AccountRepository {

    private Map<UUID, Account> accountMap = new HashMap<>();

    public Account save(Account account) {
        System.out.println("in Repository account = " + account);
        accountMap.put(account.getAccountId().getAccountIdUUID(), account);
        return account;
    }

    public Account find(UUID accountId) {
        return accountMap.get(accountId);
    }
}
