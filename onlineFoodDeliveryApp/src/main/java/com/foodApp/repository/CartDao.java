package com.foodApp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.foodApp.model.FoodCart;


@Repository
public interface CartDao extends JpaRepository<FoodCart,Integer>{
	
}