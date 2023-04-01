package com.foodApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.foodApp.model.Item;


@Repository
public interface ItemDao extends JpaRepository<Item,Integer>{
	public Item findByItemName(String Name);
}
