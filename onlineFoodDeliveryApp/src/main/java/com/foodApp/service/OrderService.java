package com.foodApp.service;

import com.foodApp.model.Item;
import com.foodApp.model.OrderDetails;

import java.util.List;

public interface OrderService {
    public OrderDetails addOrders(OrderDetails orderDetails);
    public OrderDetails updateOrders(OrderDetails orderDetails);
    public OrderDetails removeOrder(OrderDetails orderDetails);
    public OrderDetails viewOrderById(Integer id);
    public List<Item> viewOrdersByCustomerId(Integer CustomerId);

}
