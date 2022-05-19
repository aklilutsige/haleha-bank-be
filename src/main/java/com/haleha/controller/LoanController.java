package com.haleha.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {
    @GetMapping("/loans")
    public String getLoans(String input){
        return "Get Loans data from DB services . . ";
    }
}
