package com.foodApp.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.foodApp.model.Restaurant;


@Repository
public interface ResturantDao extends JpaRepository<Restaurant, Integer>{
	
	//public Restaurant findByResturantName(String Name);
}

 