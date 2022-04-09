package com.marsh.iStore.controller.restController;

import com.marsh.iStore.entity.Product;
import com.marsh.iStore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductRestController {

    private ProductService productService;

    @Autowired
    public ProductRestController(ProductService  productService){
        this.productService = productService;
    }

    @GetMapping("api/v1/products")
    public List<Product> getAllProduct(){
        return productService.getListAllProduct();
    }
}
