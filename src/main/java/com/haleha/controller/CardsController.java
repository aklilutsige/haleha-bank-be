package com.haleha.controller;

import com.haleha.model.Cards;
import com.haleha.model.Customer;
import com.haleha.repository.CardsRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardsController {
    public static final String URL = "/myCards";

    private final CardsRepository cardsRepository;

    public CardsController(CardsRepository cardsRepository) {
        this.cardsRepository = cardsRepository;
    }

    @PostMapping(URL)
    public List<Cards> getCardDetails(@RequestBody Customer customer) {
        return cardsRepository.findByCustomerId(customer.getId());
    }
}
