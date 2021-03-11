package com.example.demo.service;

import com.example.demo.dao.OrderRepository;
import com.example.demo.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServicelmpl implements OrderService{

        private OrderRepository orderRepository;

        @Autowired
        public OrderServicelmpl(OrderRepository theOrderRepository) {
            orderRepository = theOrderRepository;
        }

        @Override
        public List<Order> findAll() {
            return orderRepository.findAll();
        }

        @Override
        public Order findById(int theId) {
            Optional<Order> result = orderRepository.findById(theId);

            Order theOrder = null;

            if (result.isPresent()) {
                theOrder = result.get();
            }
            else {
                // we didn't find the employee
                throw new RuntimeException("Did not find order id - " + theId);
            }

            return theOrder;
        }

        @Override
        public int save(Order theOrder) { orderRepository.save(theOrder);
            return theOrder.getId();
        }


}
