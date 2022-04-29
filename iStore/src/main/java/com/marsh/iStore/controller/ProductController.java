package com.marsh.iStore.controller;

import com.marsh.iStore.model.Product;
import com.marsh.iStore.model.User;
import com.marsh.iStore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    // вернет нам корневую страницу
    // вернет весь список продукта
    @GetMapping
    public String getAllProducts(
            @RequestParam(required = false, defaultValue = "") String titleFilter,
            Model model
    ){
        List<Product> products = productService.getListAllProduct();

        if(titleFilter != null && !titleFilter.isEmpty())
            products = productService.getListByTitle(titleFilter);
        else
            products = productService.getListAllProduct();

        model.addAttribute("products", products);
        model.addAttribute("titleFilter", titleFilter);

        return "mainPage";
    }

    // добовляем продукт
    @PostMapping
    public String addProduct(
            @AuthenticationPrincipal User user,
            @RequestParam String title,
            @RequestParam String description,
            @RequestParam Double price,
            @RequestParam(defaultValue = "no image") String image,
            Model model)
    {
        // сохраняем новый продукт
        Product product = new Product(title, description, price, image, user);
        productService.save(product);

        // вытягиваем все продукты из репозитория и передаем в модель
        List<Product> products = productService.getListAllProduct();
        model.addAttribute("products", products);
        return "mainPage";
    }

}
