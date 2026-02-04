package org.example.cardservice.service;

import org.example.cardservice.entity.Card;

import java.util.List;

public interface CardService {
    public List<Card> getAllCards();

    public Card getCardById(Long id) ;

    public List<Card> getCardsByAccountId(Long accountId);

    public Card saveCard(Card card) ;

    public void deleteCard(Long id) ;
}