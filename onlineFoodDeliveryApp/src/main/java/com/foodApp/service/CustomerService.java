package com.foodApp.service;

import com.foodApp.Exception.CustomerException;
import com.foodApp.Exception.UserAlreadyExistWithEmail;
import com.foodApp.model.Customer;

public interface CustomerService {
	
	public Customer saveCustomer(Customer customer);
	public Customer updateCustomer(Customer customer) throws CustomerException, UserAlreadyExistWithEmail;
	public Customer removeCustomer()throws CustomerException;
	public Customer viewCustomer() throws CustomerException;
}
