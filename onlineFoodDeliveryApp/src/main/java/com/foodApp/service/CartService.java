package com.foodApp.service;

import com.foodApp.Exception.ItemUnavailable;
import com.foodApp.model.FoodCart;
import com.foodApp.model.Item;
import com.foodApp.model.Restaurant;

public interface CartService{	
	
	public FoodCart addItemToCart(Integer cartid, Integer itemname) throws ItemUnavailable;
//	public List<CartItem> getCartItems(String token);
//	public Cart removeItemFromCart(CartDto cartDto,String token) throws ItemUnavailable;

	public FoodCart saveCart(FoodCart cart)throws ItemUnavailable;

	public FoodCart viewCartByCartId(Integer cartId)throws ItemUnavailable;

	public FoodCart removeCart(Integer cartId)throws ItemUnavailable;
	
	public FoodCart cartDetailsforOrder(Integer user_Id, Integer quantity, Integer cartId)throws ItemUnavailable;
}

