package com.marsh.iStore.controller;

import com.marsh.iStore.model.Order;
import com.marsh.iStore.model.Product;
import com.marsh.iStore.model.User;
import com.marsh.iStore.service.OrderService;
import com.marsh.iStore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @GetMapping
    public String getAllOrders(Model model){
        List<Order> orders = orderService.getAllOrder();
        model.addAttribute("orders", orders);

        return "ordersPage";
    }

    private int exists(Integer id, Order orders) {
        for (int i = 0; i < orders.getQuantity(); i++) {
            if (orders.getProduct().getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }
}
