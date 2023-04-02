package com.foodApp.service;

import com.foodApp.model.Card;

import java.util.List;

public interface CardService {
    public Card saveCard(Card card);
    public List<Card> getAllCustomerCard();
    public Card deleteCard();
    public List<Card> getAllCards();
}
