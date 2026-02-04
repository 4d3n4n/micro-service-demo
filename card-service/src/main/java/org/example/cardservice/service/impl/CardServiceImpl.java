package org.example.cardservice.service.impl;

import org.example.cardservice.entity.Card;
import org.example.cardservice.repository.CardRepository;
import org.example.cardservice.service.CardService;
import org.example.cardservice.client.AccountClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private AccountClient accountClient;

    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    public Card getCardById(Long id) {
        return cardRepository.findById(id).orElseThrow(() -> new RuntimeException("Card not found"));
    }

    public List<Card> getCardsByAccountId(Long accountId) {
        return cardRepository.findByAccountId(accountId);
    }

    public Card saveCard(Card card) {
        if (!accountClient.accountExists(card.getAccountId())) {
            throw new RuntimeException("Account not found with id: " + card.getAccountId());
        }
        return cardRepository.save(card);
    }

    public void deleteCard(Long id) {
        cardRepository.deleteById(id);
    }
}
