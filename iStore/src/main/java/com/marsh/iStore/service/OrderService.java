package com.marsh.iStore.service;

import com.marsh.iStore.model.Order;
import com.marsh.iStore.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public void save(Order order){
        orderRepository.save(order);
    }

    public List<Order> getAllOrder(){
        return orderRepository.findAllOrder();
    }

    public Order getOrderById(Integer id){
        return orderRepository.findById(id).orElse(null);
    }
}
