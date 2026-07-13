package com.cognizant.orderservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.orderservice.dto.UserDTO;
import com.cognizant.orderservice.entity.Order;
import com.cognizant.orderservice.feign.UserClient;
import com.cognizant.orderservice.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserClient userClient;

    public Order saveOrder(Order order) {

        UserDTO user = userClient.getUserById(order.getUserId());

        if (user == null) {
            throw new RuntimeException("User Not Found");
        }

        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Integer id) {
        return orderRepository.findById(id).orElse(null);
    }
}
