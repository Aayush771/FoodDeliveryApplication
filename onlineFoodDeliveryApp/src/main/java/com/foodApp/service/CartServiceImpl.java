package com.foodApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.foodApp.AppSecurity.GetCurrentLoginUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodApp.Exception.ItemUnavailable;
import com.foodApp.Exception.NoItemFoundInFoodcart;
import com.foodApp.model.Customer;
import com.foodApp.model.FoodCart;
import com.foodApp.model.Item;
import com.foodApp.repository.CartDao;
import com.foodApp.repository.CustomerDAO;
import com.foodApp.repository.ItemDao;


@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private ItemDao itemDao;
	@Autowired
	private CustomerDAO customerDAO;

	@Autowired
	private GetCurrentLoginUserDetails currentLoginUserDetails;

	@Override
	public FoodCart addItemToCart(Integer itemId) throws ItemUnavailable {

		if (currentLoginUserDetails.checkLogin()) {
			Customer customer = currentLoginUserDetails.getCurrentCustomer();
			FoodCart foodCart = customerDAO.findFoodCartByCustomerId(customer.getCustomerId());
			Optional<Item> item = itemDao.findById(itemId);
			if (item.isPresent()) {

				Optional<Item> i = itemDao.findById(itemId);

				Item gotit = i.get();
//				if (i != null) {
//
//					Item fd = item.get();
//
//					List<Item> l1 = new ArrayList<>();
//
//					l1.addAll(fd.getItems());
//					l1.add(gotit);
//
//					fd.setItems(l1);
//
//					System.out.println(fd);
//
//					return fd;
//				}
				throw new ItemUnavailable("Sorry no item found");
			}
			throw new NoItemFoundInFoodcart("not found");
		}
		return null;
	}

	@Override
	public FoodCart saveCart(FoodCart cart) {
		
		if(cart!=null)
		return cartDao.save(cart);
		throw new ItemUnavailable("cant save");
	}

	@Override
	public FoodCart viewCartByCartId(Integer cartId) {
	   Optional<FoodCart> f=cartDao.findById(cartId);
	   if(f.isPresent()) {
       	FoodCart existingcart= f.get();
       	
       	return existingcart;
	   }
		 throw new NoItemFoundInFoodcart("not found");		
	}

	@Override
	public FoodCart removeCart(Integer cartId) {
		
		   Optional<FoodCart> f=cartDao.findById(cartId);
		   if(f.isPresent()) {
	       	FoodCart existingcart= f.get();
	       	
	       	 cartDao.delete(existingcart);
	       	
	       	return existingcart;
		   }
			 throw new NoItemFoundInFoodcart("not found");
	}

	@Override //extra method controller not exist
	public FoodCart cartDetailsforOrder(Integer customerId, Integer quantity, Integer cartId)
			throws ItemUnavailable {
		
		Customer customer = customerServiceImpl.viewCustomer();
		
		if( customer != null ){
			
			Optional<FoodCart> opt= cartDao.findById(cartId);
			
			if(opt.isPresent()) {
				
				FoodCart existingCart= opt.get();
				
				cartDao.save(existingCart);
				
				return existingCart;
				
			}
			else{
				throw new ItemUnavailable("Cart is Empty..!");
			}
		}
		
		else{
			throw new ItemUnavailable("Please enter correct credentials...");
		}
	}



//	@Override
//	public List<CartItem> getCartItems(String token) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Cart removeItemFromCart(CartDto cartDto, String token) throws ItemUnavailable {
//		// TODO Auto-generated method stub
//		return null;
//	}
}


