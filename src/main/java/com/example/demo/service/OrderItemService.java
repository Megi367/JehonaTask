package com.example.demo.service;

import com.example.demo.models.OrderItem;
import java.util.List;

public interface OrderItemService {
    public List<OrderItem> findAll();

    public OrderItem findById(int theId);

    public void save(OrderItem theOrderItem);

}
