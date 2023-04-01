package com.foodApp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.foodApp.Exception.ItemException;
import com.foodApp.model.Item;
import com.foodApp.model.Restaurant;
import com.foodApp.repository.ItemDao;
import com.foodApp.repository.ResturantDao;

@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	private ItemDao itemDao;
	
	@Autowired
	private ResturantDao resturantDao;

	@Override
	public Item addItem(Item i) {
		// TODO Auto-generated method stub
		return itemDao.save(i);
	}

	@Override
	public Item updateItem(Item i)   {
		// TODO Auto-generated method stub
		java.util.Optional<Item> optI = itemDao.findById(i.getItemId());

	
		if(optI.isPresent()) {
			
			Item existingItem= optI.get();
			
			return itemDao.save(i);
		}
		else {
			throw new ItemException("Invalid item Details..");
		}
	  
	}
	


	@Override
	public Item removeItem(Integer i) {
java.util.Optional<Item> optI = itemDao.findById(i);
		
		if(optI.isPresent()) {
			
			Item existingResturant= optI.get();
			
			itemDao.delete(existingResturant);
		   
		   return existingResturant;
		}
		throw new ItemException("Invalid item Details..");
	}

	@Override
	public Item viewItem(Integer i) {
		java.util.Optional<Item> optI = itemDao.findById(i);
		if(optI.isPresent()) {
			
			Item existingResturant= optI.get();
			
		   return existingResturant;
		}
		throw new ItemException("Invalid item Details..");
	}

	@Override
	public List<Item> viewAllItemResturant(Restaurant res) {
		List<Item> items = itemDao.findAll();
		
		if(items.size()==0) {
			throw new ItemException("Invalid item Details..");
		}
		return items;
	}

	@Override
	public List<Item> viewAllItemByName(String name) {
		
//		Restaurant n =  resturantDao.findByResturantName(name);
//		
//		if(n!= null) {
//			
//			return n.getItemlist();
//		}
//		throw new ItemException("Invalid item Details..");
		
		return null;
	}
}
	
	
	
	
	
	
	
	
