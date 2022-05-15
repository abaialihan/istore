package com.marsh.iStore.controller.restController;

import com.marsh.iStore.model.Product;
import com.marsh.iStore.model.User;
import com.marsh.iStore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("api/v1/products")
public class ProductRestController {

    private ProductService productService;

    @Autowired
    public ProductRestController(ProductService  productService){
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProduct(){
        return productService.getListAllProduct();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Integer id){

        // обрабатываем запрос по id
        // если нет элемента по id
        // ловим ошибку и выдаем статус NOTFOUND
        try {
            Product product = productService.getProductById(id);
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(
            @RequestParam User user,
            @RequestParam String title,
            @RequestParam String description,
            @RequestParam Double price,
            @RequestParam(defaultValue = "no image") String image
    )
    {
        Product product = new Product(title, description, price, image, user);
        productService.save(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(
            @RequestParam String title,
            @RequestParam String description,
            @RequestParam Double price,
            @PathVariable Integer id
    )
    {
        try {
            Product product = productService.getProductById(id);
            product.setTitle(title);
            product.setDescription(description);
            product.setPrice(price);
            productService.save(product);

            return new ResponseEntity<>(product, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        productService.delete(id);
    }
}
