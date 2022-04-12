package com.marsh.iStore.controller.restController;

import com.marsh.iStore.entity.Product;
import com.marsh.iStore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

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

    @GetMapping("api/v1/products/{id}")
    public ResponseEntity<Product> getById(@PathVariable Integer id){

        // обрабатываем запрос по id
        // если нет элемента по id
        // ловим ошибку и выдаем статус NOTFOUND
        try {
            Product product = productService.get(id);
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("api/v1/products")
    public void addProduct(@RequestBody Product product){
        productService.save(product);
    }

    @PutMapping("api/v1/products/{id}")
    public ResponseEntity<?> update(@RequestBody Product product,
                                    @PathVariable Integer id)
    {
        try {
            Product gotProduct = productService.get(id);
            productService.save(product);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("api/v1/products/{id}")
    public void delete(@PathVariable Integer id){
        productService.delete(id);
    }
}
