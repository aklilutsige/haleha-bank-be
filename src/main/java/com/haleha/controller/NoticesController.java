package com.haleha.controller;

import com.haleha.repository.CustomerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticesController {
    private CustomerRepository customerRepository;

    @GetMapping("/notices")
    public String getNotices(String input){
        return "Connected to Notices data service.";
    }
}
