package com.foodApp.controller;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foodApp.Exception.NotFoundException;
import com.foodApp.model.Restaurant;
import com.foodApp.service.RestaurantService;

@RestController
public class ResturantController{
	
	@Autowired
	private RestaurantService resSer;
	
	@PostMapping("/resturant")
	public ResponseEntity<Restaurant> saveResturant(@Valid @RequestBody Restaurant res) {
		
		Restaurant r = resSer.addResturant(res);
		
		return new ResponseEntity<Restaurant>(r,HttpStatus.ACCEPTED);
	}
	
	//-------------------------------Login authentication added------------------------------------
	
	
	@DeleteMapping("/resturant/{resturantId}")
	public Restaurant deleteResturant(@PathVariable ("resturantId") Integer rId){
		
		return resSer.removeResturant(rId);
	}
	
	
	@PutMapping("/resturant")
	public ResponseEntity<Restaurant> updateResturant(@Valid @RequestBody Restaurant rest){
		
		Restaurant updatedResturant=resSer.updateResturant(rest);
		
		return new ResponseEntity<Restaurant>(updatedResturant,HttpStatus.ACCEPTED);
	}
//	@PutMapping("/resturant/{resturantId}")
//	public ResponseEntity<Student> updateStudentMarks(@PathVariable("roll") Integer roll,@RequestParam("marks") Integer marks) {
//		
//		Student updatedStudent = sService.updateStudentMarks(roll, marks);
//		
//		return new ResponseEntity<Student>(updatedStudent,HttpStatus.ACCEPTED);
//		
//	}
			
	@GetMapping("/resturantById/{itemName}")
	public ResponseEntity<List<Restaurant>> viewResturant(String name){
		List<Restaurant> rest= resSer.viewResturantByItemName(name);
		
		return new ResponseEntity<List<Restaurant>>(rest, HttpStatus.OK);
	}
	
	@GetMapping("/resturant/{location}")
	public ResponseEntity<List<Restaurant>> viewResturantByLocation(String location){
		List<Restaurant> rest= resSer.viewNearByResturant(location);
		
		return new ResponseEntity<List<Restaurant>>(rest, HttpStatus.OK);
	}
	
}

//package com.foodApp.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.foodApp.model.Resturant;
//import com.foodApp.service.ResturantService;
//
//@RestController
//public class ResturantController{
//	
//	@Autowired
//	private ResturantService resSer;
//	
//	@PostMapping("/Resturant")
//	public Resturant saveResturant(@RequestBody Resturant res) {
//		
//		Resturant r = resSer.addResturant(res);
//		
//		return r;
//	}
//}
