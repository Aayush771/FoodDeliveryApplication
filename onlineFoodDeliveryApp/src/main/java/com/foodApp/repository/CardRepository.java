package com.foodApp.repository;

import com.foodApp.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CardRepository extends JpaRepository<Card,Integer> {
    public List<Card> findAllByCustomerCustomerId(Integer id);
}
