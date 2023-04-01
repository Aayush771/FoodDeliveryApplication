package com.foodApp.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodApp.Exception.ResturantNotFoundException;
import com.foodApp.model.Restaurant;
import com.foodApp.repository.ItemDao;
import com.foodApp.repository.ResturantDao;


@Service
public class RestaurantServiceImpl implements RestaurantService{

	@Autowired
	private ResturantDao resturantDao;
	@Autowired
	private ItemDao itemDao;
	
	@Override
	public Restaurant addResturant(Restaurant res) {
		// TODO Auto-generated method stub
		return resturantDao.save(res);
	}
	@Override
	public Restaurant updateResturant(Restaurant res) {
		// TODO Auto-generated method stub
		
				Optional<Restaurant> optR = resturantDao.findById(res.getRestaurantId());
				
				if(optR.isPresent()) {
					
					Restaurant existingResturant= optR.get();
					
					return resturantDao.save(res);
				}
				return null;
	}

	@Override
	public Restaurant removeResturant(Integer res) {
		Optional<Restaurant> optR = resturantDao.findById(res);
		
		if(optR.isPresent()) {
			
			Restaurant existingResturant= optR.get();
			
			
			resturantDao.delete(existingResturant);
		   
		   return existingResturant;
		}
		return null;
	}

//		Optional<Resturant> optR = rdao.findById(res.getResturantId());
//		
//		if(optR.isPresent()) {
//			
//			Resturant existingResturant= optR.get();
//			
//			return rdao.save(res);
//		}

	@Override
	public Restaurant viewResturantByResturantId(Integer res) {
   Optional<Restaurant> optR = resturantDao.findById(res);
		
		if(optR.isPresent()) {
			
			Restaurant existingResturant= optR.get();
			
		    return existingResturant;
					
		}
		throw new ResturantNotFoundException("Resturant not available with provided ResturantId");
	}

	@Override
	public List<Restaurant> viewNearByResturant(String location) {
		
		return null;
	}

	@Override
	public List<Restaurant> viewResturantByItemName(String name) {
		
		return null;
	}
}
