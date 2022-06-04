package com.haleha.controller;

import com.haleha.model.Accounts;
import com.haleha.model.Customer;
import com.haleha.repository.AccountsRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    public static final String URL = "/myAccount";

    private final AccountsRepository accountsRepository;

    public AccountController(AccountsRepository accountsRepository) {
        this.accountsRepository = accountsRepository;
    }

    @PostMapping(URL)
    public Accounts getAccountDetails(@RequestBody Customer customer) {
        return accountsRepository.findByCustomerId(customer.getId());
    }
}
