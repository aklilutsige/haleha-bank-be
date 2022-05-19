package com.haleha.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardController {
    @GetMapping("/cards")
    public String getCards(String input){
        return "Here are from Card DB";
    }
}
