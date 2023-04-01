package com.foodApp.service;

import java.util.List;

import com.foodApp.Exception.ResturantNotFoundException;
import com.foodApp.model.Restaurant;

public interface RestaurantService {

	public Restaurant addResturant(Restaurant res) throws ResturantNotFoundException;
	
	public Restaurant updateResturant(Restaurant res) throws ResturantNotFoundException;
	
	public Restaurant removeResturant(Integer resturantId) throws ResturantNotFoundException;
	
	public Restaurant viewResturantByResturantId(Integer resturantId) throws ResturantNotFoundException;
	
	public List<Restaurant> viewNearByResturant(String location) throws ResturantNotFoundException;
	
	public List<Restaurant> viewResturantByItemName(String name) throws ResturantNotFoundException;
	
	//public List<Item> addAllItems(Item i);
}
