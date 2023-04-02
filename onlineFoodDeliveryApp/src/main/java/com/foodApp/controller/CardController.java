package com.foodApp.controller;

import com.foodApp.model.Card;
import com.foodApp.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CardController {
    @Autowired
    private CardService cardService;
    @PostMapping("/card")
    public ResponseEntity<Card> saveCardDetailsHandler(@RequestBody Card card)
    {
        Card savedCard = cardService.saveCard(card);
        return new ResponseEntity<>(savedCard, HttpStatus.CREATED);
    }
    @GetMapping("/card")
    public ResponseEntity<List<Card>> getAllCustomerCardsHandler()
    {
        List<Card> savedCards = cardService.getAllCustomerCard();
        return new ResponseEntity<>(savedCards, HttpStatus.OK);
    }
    @DeleteMapping ("/card")
    public ResponseEntity<Card> deleteCardHandler()
    {
        Card deleteCard = cardService.deleteCard();
        return new ResponseEntity<>(deleteCard, HttpStatus.ACCEPTED);
    }
    @GetMapping("/cards")
    public ResponseEntity<List<Card>> findAllCardHandler()
    {
        List<Card> savedCards = cardService.getAllCards();
        return new ResponseEntity<>(savedCards, HttpStatus.OK);
    }
}
