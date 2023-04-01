package com.foodApp.service;



import com.foodApp.Exception.CustomerException;
import com.foodApp.model.Customer;
import com.foodApp.model.Item;
import com.foodApp.model.OrderDetails;
import com.foodApp.repository.CustomerDAO;
import com.foodApp.repository.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class OrderServideIml implements OrderService{
    
	@Autowired
    OrderDao orderDao;
	@Autowired
	CustomerDAO customerDAO;

    @Override
    public OrderDetails addOrders(OrderDetails orderDetails) {
        Optional<OrderDetails> opt = orderDao.findById(orderDetails.getOrderId());
        if (opt.isPresent()) {
            throw  new CustomerException("Orders Already Exist");
        }
        else  orderDao.save(orderDetails);
        return orderDetails;
    }

    @Override
    public OrderDetails updateOrders(OrderDetails orderDetails) {
        Optional<OrderDetails> opt = orderDao.findById(orderDetails.getOrderId());
        if (opt.isPresent()) {
            orderDao.save(orderDetails);
        }
        else   throw  new CustomerException("Orders Already Exist");
        return orderDetails;
    }

    @Override
    public OrderDetails removeOrder(OrderDetails orderDetails) {

        OrderDetails orderDetails1=orderDao.findById(orderDetails.getOrderId()).orElseThrow(()-> new CustomerException("Order not Found"));
        orderDao.delete(orderDetails1);
        return orderDetails1;
    }

    @Override
    public OrderDetails viewOrderById(Integer id) {
        OrderDetails orderDetails1=orderDao.findById(id).orElseThrow(()-> new CustomerException("Order not Found"));

        return orderDetails1;
    }

    @Override
    public List<Item> viewOrdersByCustomerId(Integer customerId) {
        Customer customer=customerDAO.findById(customerId).orElseThrow(()-> new CustomerException("Customer Not Found"));
        List<Item> orderlist= customer.getFoodCart().getItems();
        return orderlist;
    }




}
