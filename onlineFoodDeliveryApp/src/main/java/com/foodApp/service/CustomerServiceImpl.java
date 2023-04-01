package com.foodApp.service;

import com.foodApp.AppSecurity.GetCurrentLoginUserDetails;
import com.foodApp.Exception.NotFoundException;
import com.foodApp.Exception.UserAlreadyExistWithEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.foodApp.repository.CustomerDAO;
import com.foodApp.Exception.CustomerException;
import com.foodApp.model.Customer;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO cDao;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private GetCurrentLoginUserDetails currentLoginUserDetails;
	@Override
	public Customer saveCustomer(Customer customer) {
		Optional<Customer> opt = cDao.findCustomerByEmail(customer.getEmail());
		if(opt.isPresent()){
			throw new CustomerException("No user found.. try login first ");
		}
		customer.setPassword(passwordEncoder.encode(customer.getPassword()));
		return cDao.save(customer);
	}
	@Override
	public Customer updateCustomer(Customer customer)  {

		if (currentLoginUserDetails.checkLogin()) {
			Optional<Customer> opt = cDao.findCustomerByEmail(customer.getEmail());

			if (opt.isPresent()) {
				Customer customer1 = opt.get();
				customer1.setEmail(customer.getEmail());
				customer1.setName(customer.getName());
				customer1.setRole(customer.getRole());
				return cDao.save(customer1);
			}else{
				throw new UserAlreadyExistWithEmail("User don't exist with this mobile number");
			}

		} else {
			throw new NotFoundException("No user found.. try login first");
		}
	}
	@Override
	public Customer removeCustomer() throws CustomerException {

		if (currentLoginUserDetails.checkLogin()) {
			Customer customer = currentLoginUserDetails.getCurrentCustomer();
			System.out.println("Before");
			cDao.delete(customer);
			System.out.println("Before");
			return customer;

		} else {
			throw new NotFoundException("No user found.. try login first");
		}

	}
	@Override
	public Customer viewCustomer() throws CustomerException {
		// TODO Auto-generated method stub
		if (currentLoginUserDetails.checkLogin()) {

			return currentLoginUserDetails.getCurrentCustomer();

		} else {
			throw new NotFoundException("No user found.. try login first");
		}
	}
	
	

}
