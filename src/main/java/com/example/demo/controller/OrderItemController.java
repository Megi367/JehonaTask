package com.example.demo.controller;

import com.example.demo.models.Order;
import com.example.demo.models.OrderItem;
import com.example.demo.service.OrderItemService;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class OrderItemController {
    private OrderItemService orderItemService;

@Autowired
public OrderItemController(OrderItemService theOrderItemService) { orderItemService = theOrderItemService;
}

    // expose "/order items" and return list of order items
    @GetMapping("/oitems")
    public List<OrderItem> findAll() {
        return orderItemService.findAll();
    }

    // add mapping for GET /order items/{itemId}

    @GetMapping("/oitems/{itemId}")
    public OrderItem getOrderItem (@PathVariable int itemId) {

        OrderItem theOrderItem = orderItemService.findById(itemId);

        if (theOrderItem == null) {
            throw new RuntimeException("Item id not found - " + itemId);
        }

        return theOrderItem;
    }

    // add mapping for POST /order items - add new order item

    @PostMapping("/oitems")
    public OrderItem addOrderItem(@RequestBody OrderItem theOrderItem) {

        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update

        theOrderItem.setItemId(0);

        orderItemService.save(theOrderItem);

        return theOrderItem;
    }

}
