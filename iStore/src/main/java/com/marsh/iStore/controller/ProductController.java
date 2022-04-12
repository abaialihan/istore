package com.marsh.iStore.controller;

import com.marsh.iStore.entity.Product;
import com.marsh.iStore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    // вернет нам корневую страницу
    // вернет весь список продукта
    @GetMapping
    public String getAllProducts(Model model){
        List<Product> products = productService.getListAllProduct();
        model.addAttribute("products", products);

        return "mainPage";
    }

    // добовляем продукт
    @PostMapping
    public String addProduct(
            @RequestParam String title,
            @RequestParam String description,
            @RequestParam String price,
            @RequestParam(defaultValue = "no image") String image,
            Model model)
    {
        // сохраняем новый продукт
        Product product = new Product(title, description, price, image);
        productService.save(product);

        // вытягиваем все продукты из репозитория и передаем в модель
        List<Product> products = productService.getListAllProduct();
        model.addAttribute("products", products);
        return "mainPage";
    }

    // вернет продукты по названию
    @PostMapping("findByTitle")
    public String findByTitle(@RequestParam String title,
                              Model model)
    {
        List<Product> products;

        if(title != null && !title.isEmpty()) {
            products = productService.getListByTitle(title);
        }else {
            products = productService.getListAllProduct();
        }
        model.addAttribute(products);

        return "mainPage";
    }
}
