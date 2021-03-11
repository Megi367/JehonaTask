package com.example.demo.service;

import com.example.demo.dao.OrderItemRepository;
import com.example.demo.models.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OrderItemServicelmpl implements OrderItemService {

        private OrderItemRepository orderItemRepository;

        @Autowired
        public void OrderItemService (OrderItemRepository theOrderItemRepository) {
            orderItemRepository = theOrderItemRepository;
        }

        @Override
        public List<OrderItem> findAll() {

            return orderItemRepository.findAll();
        }

        @Override
        public OrderItem findById(int theId) {
            Optional<OrderItem> result = orderItemRepository.findById(theId);

            OrderItem theOrderItem = null;

            if (result.isPresent()) {
                theOrderItem = result.get();
            }
            else {
                // we didn't find the employee
                throw new RuntimeException("Did not find orderitem id - " + theId);
            }

            return theOrderItem;
        }

        @Override
        public void save(OrderItem theOrderItem) {
            orderItemRepository.save(theOrderItem);
        }

}
