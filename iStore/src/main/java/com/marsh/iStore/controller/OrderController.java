package com.marsh.iStore.controller;

import com.marsh.iStore.model.Order;
import com.marsh.iStore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public String getAllListOrders(Model model){
        List<Order> orders = orderService.getAllOrder();

        model.addAttribute("orders", orders);
        return "orders";
    }
}
