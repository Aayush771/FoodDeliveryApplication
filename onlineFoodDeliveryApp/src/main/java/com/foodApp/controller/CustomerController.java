package com.foodApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.foodApp.model.Customer;
import com.foodApp.service.CustomerService;


@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService cService;
	
	@PostMapping("/customer")
	public ResponseEntity<Customer> saveCustomerDetailsHandler(@RequestBody Customer customer)
	{
		Customer savedCustomer = cService.saveCustomer(customer);
		return new ResponseEntity<Customer>(savedCustomer,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/customer")
	public Customer removeCustomerByIdHandler(){
		return cService.removeCustomer();
	}
	
	@GetMapping("/customer/")
	public Customer viewCustomerHandler() {
		return cService.viewCustomer();
	}
	
	@PutMapping("/customer")
	public ResponseEntity<Customer> updateCustomerHandler(@RequestBody Customer customer){
		
		Customer updatedCustomer = cService.updateCustomer(customer);
		
		return new ResponseEntity<Customer>(updatedCustomer,HttpStatus.ACCEPTED);
	}
}
