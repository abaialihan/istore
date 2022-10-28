package com.marsh.iStore.controller;

import com.marsh.iStore.model.Product;
import com.marsh.iStore.model.User;
import com.marsh.iStore.model.dto.ProductDto;
import com.marsh.iStore.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/products")
public class ProductRestController {

    private final ProductService productService;

    @GetMapping("/all")
    public List<Product> getAllProduct(){
        return productService.getListAllProduct();
    }

    @GetMapping("/{id}")
    public ProductDto getById(@PathVariable Integer id){
        return productService.getProductById(id);
    }

    @PostMapping("/add-product")
    public Object addProduct(@RequestParam User user, @RequestParam String title, @RequestParam String description,
                                 @RequestParam Double price, @RequestParam(defaultValue = "no image") String image)
    {
        return productService.addProduct(user, title, description, price, image);
    }

    @PutMapping("/update-product/{id}")
    public Object update(@RequestParam String title, @RequestParam String description, @RequestParam Double price, @PathVariable Integer id) {
        return productService.update(title, description, price, id);
    }

    @DeleteMapping("/{id}")
    public Object delete(@PathVariable Integer id){
        return productService.delete(id);
    }
}
