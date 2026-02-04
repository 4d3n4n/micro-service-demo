package org.example.cardservice.controller;


import org.example.cardservice.entity.Card;
import org.example.cardservice.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
public class CardController {
    @Autowired
    private CardService cardService;

    @GetMapping
    public List<Card> getAllCards() {
        return cardService.getAllCards();
    }

    @GetMapping("/{id}")
    public Card getCardById(@PathVariable Long id) {
        return cardService.getCardById(id);
    }

    @GetMapping("/accounts/{accountId}")
    public List<Card> getCardsByAccountId(@PathVariable Long accountId) {
        return cardService.getCardsByAccountId(accountId);
    }

    @PostMapping
    public Card createCard(@RequestBody Card card) {
        return cardService.saveCard(card);
    }

    @DeleteMapping("/{id}")
    public void deleteCard(@PathVariable Long id) {
        cardService.deleteCard(id);
    }

}
