package com.haleha.controller;

import com.haleha.model.AccountTransactions;
import com.haleha.model.Customer;
import com.haleha.repository.AccountTransactionsRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BalanceController {
    public static final String URL = "/myBalance";

    private final AccountTransactionsRepository accountTransactionsRepository;

    public BalanceController(AccountTransactionsRepository accountTransactionsRepository) {
        this.accountTransactionsRepository = accountTransactionsRepository;
    }

    @PostMapping(URL)
    public List<AccountTransactions> getBalanceDetails(@RequestBody Customer customer) {
        return accountTransactionsRepository.findByCustomerIdOrderByTransactionDtDesc(customer.getId());
    }
}
