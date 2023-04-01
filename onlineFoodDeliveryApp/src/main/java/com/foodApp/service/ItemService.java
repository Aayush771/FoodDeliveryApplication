package com.foodApp.service;

import java.util.List;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import com.foodApp.model.Item;
import com.foodApp.model.Restaurant;

public interface ItemService {
	
	public Item addItem(Item i)throws NotFoundException;
	
	public Item updateItem(Item i)throws NotFoundException;
	
	public Item removeItem(Integer itemId)throws NotFoundException;
	
	public Item viewItem(Integer itemId)throws NotFoundException;
	
	public List<Item> viewAllItemResturant(Restaurant res)throws NotFoundException;

	public List<Item> viewAllItemByName(String name)throws NotFoundException;
}
