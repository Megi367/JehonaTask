package com.example.demo.controller;

import com.example.demo.models.Order;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class OrderController {
    private OrderService orderService;
    @Autowired
    public OrderController(OrderService theOrderService) { orderService = theOrderService;
    }

    // expose "/orders" and return list of orders
    @GetMapping("/orders")
    public List<Order> findAll() {
        return orderService.findAll();
    }

    // add mapping for GET /orders/{orderId}

    @GetMapping("/orders/{orderId}")
    public Order getOrder (@PathVariable int orderId) {

        Order theOrder = orderService.findById(orderId);

        if (theOrder == null) {
            throw new RuntimeException("Order id not found - " + orderId);
        }

        return theOrder;
    }

    // add mapping for POST /orders - add new order

    @PostMapping("/orders")
    public int addOrder(@RequestBody Order theOrder) {

        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update

        return orderService.save(theOrder);

    }


}
