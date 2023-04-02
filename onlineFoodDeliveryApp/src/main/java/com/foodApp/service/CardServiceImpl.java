package com.foodApp.service;

import com.foodApp.AppSecurity.GetCurrentLoginUserDetails;
import com.foodApp.Exception.NotFoundException;
import com.foodApp.model.Card;
import com.foodApp.model.Customer;
import com.foodApp.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CardServiceImpl implements CardService{
    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private GetCurrentLoginUserDetails currentLoginUserDetails;
    @Override
    public Card saveCard(Card card) {

        if (currentLoginUserDetails.checkLogin()) {
         Customer customer =   currentLoginUserDetails.getCurrentCustomer();
           List<Card> cards = cardRepository.findAllByCustomerCustomerId(customer.getCustomerId());
           if(cards.size() == 0){
               List<Card> cards1 = new ArrayList<>();
               card.setCustomer(customer);
               cards1.add(card);
               customer.setCards(cards1);
               cardRepository.save(card);
           }else{
               card.setCustomer(customer);
               cards.add(card);
               customer.setCards(cards);
               cardRepository.save(card);
           }

           return card;
        } else {
            throw new NotFoundException("No user found.. try login first");
        }
    }

    @Override
    public List<Card> getAllCustomerCard() {
        if (currentLoginUserDetails.checkLogin()) {
            Customer customer = currentLoginUserDetails.getCurrentCustomer();
            return cardRepository.findAllByCustomerCustomerId(customer.getCustomerId());
        }else  throw new NotFoundException("No user found.. try login first");
    }

    @Override
    public Card deleteCard() {
        if (currentLoginUserDetails.checkLogin()) {
            Customer customer = currentLoginUserDetails.getCurrentCustomer();
            List<Card> cards = cardRepository.findAllByCustomerCustomerId(customer.getCustomerId());
            if(cards.size() == 0){
                throw new NotFoundException("No Card found!");
            }else {
                 cardRepository.delete(cards.get(0));
                 return cards.get(0);
            }

        }else  throw new NotFoundException("No user found.. try login first");
    }

    @Override
    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }
}
