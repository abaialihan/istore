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

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @PostMapping("/addToCart/{productId}")
    public String addToCart(@AuthenticationPrincipal User userId,
            @PathVariable Product productId,
            Model model
    )
    {
        if(model.getAttribute("orders") == null){
            Order orders = new Order(1,  userId, productId.getId());
            orderService.save(orders);
            model.addAttribute("orders", orders);
        }else{
            Order orders = (Order) model.getAttribute("/order");
            orderService.save(orders);
            model.addAttribute("orders", orders);
        }

        return "redirect:/orders";
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
