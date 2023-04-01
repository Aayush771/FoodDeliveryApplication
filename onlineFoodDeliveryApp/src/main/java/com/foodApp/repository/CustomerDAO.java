package com.foodApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodApp.model.Customer;

import java.util.Optional;

@Repository
public interface CustomerDAO extends JpaRepository<Customer,Integer> {
    public Optional<Customer> findCustomerByEmail(String email);

}
