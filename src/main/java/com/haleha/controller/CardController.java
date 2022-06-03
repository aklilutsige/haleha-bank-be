package com.haleha.controller;

import com.haleha.model.Cards;
import com.haleha.model.Customer;
import com.haleha.repository.CardsRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardController {
    public static final String URL = "/myCards";
    private final CardsRepository cardsRepository;

    public CardController(CardsRepository cardsRepository) {
        this.cardsRepository = cardsRepository;
    }

    @PostMapping(URL)
    public List<Cards> getCArdDetails(@RequestBody Customer customer){
        List<Cards> cards = cardsRepository.findByCustomerId(customer.getId());
        if (cards != null){
            return cards;
        }else {
            return null;
        }
    }
}
