package com.example.demo.service;

import com.example.demo.models.Order;
import java.util.List;

public interface OrderService {
    public List<Order> findAll();

    public Order findById(int theId);

    public int save(Order theOrder);


}
