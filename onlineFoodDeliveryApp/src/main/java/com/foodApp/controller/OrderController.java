package com.foodApp.controller;

import com.foodApp.Exception.NotFoundException;
import com.foodApp.model.OrderDetails;
import com.foodApp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class OrderController {

        @Autowired
        private OrderService orderService;
        
        
      //-------------------------------Login authentication added------------------------------------	j(all)
        @PostMapping("/saveOrder")
        public ResponseEntity<OrderDetails> saveBill(@RequestBody OrderDetails orderDetails){

        		return new ResponseEntity<OrderDetails>(orderService.addOrders(orderDetails), HttpStatus.CREATED);
        }
        @PutMapping("/updateOrders")
        public ResponseEntity<OrderDetails> UpdateBill(@RequestBody OrderDetails orderDetails){
        		return new ResponseEntity<OrderDetails>(orderService.updateOrders(orderDetails),HttpStatus.ACCEPTED);

        }
        @PutMapping("/removeOrders")
        public ResponseEntity<OrderDetails> deleteBill(OrderDetails orderDetails){
        	

        		return  new ResponseEntity<OrderDetails>(orderService.removeOrder(orderDetails),HttpStatus.OK);

        }
        @GetMapping("/saveOrder/{OrderId}")
        public ResponseEntity<OrderDetails> viewAllOrders(@PathVariable("OrderId") Integer id,@RequestParam String key){

        		return  new ResponseEntity<OrderDetails>(orderService.viewOrderById(id),HttpStatus.FOUND);

        }

}
