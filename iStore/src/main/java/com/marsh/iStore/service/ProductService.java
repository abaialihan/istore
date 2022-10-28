package com.marsh.iStore.service;

import com.marsh.iStore.exceptions.ProductNotFoundException;
import com.marsh.iStore.model.Product;
import com.marsh.iStore.model.User;
import com.marsh.iStore.model.dto.ProductDto;
import com.marsh.iStore.model.dto.Success;
import com.marsh.iStore.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getListAllProduct(){
        return productRepository.findAll();
    }

    public List<Product> getListByTitle(String title){
        return productRepository.findByTitle(title);
    }

    public ProductDto getProductById(Integer id){
        Product product = null;
        try {
            product = productRepository.findById(id).get();
        }catch (NoSuchElementException e){
            throw new ProductNotFoundException("");
        }

        return ProductDto.builder()
                .description(product.getDescription())
                .imageUrl(product.getImageUrl())
                .price(product.getPrice())
                .title(product.getTitle())
                .build();
    }


    public Object addProduct(User user, String title, String description, Double price, String image){
        Product product = new Product();

        product.setTitle(title);
        product.setDescription(description);
        product.setPrice(price);
        product.setUser(user);
        product.setImageUrl(image);

        productRepository.save(product);

        return new Success(200, "Product added");
    }

    public Object update(String title, String description, Double price, Integer id){
        Product product = null;
        try {
            product = productRepository.findById(id).get();
        }catch (NoSuchElementException e){
            log.error("fuuuuuuuuuuuck aaaaaaaaaaaaaaa : {}", e);
            throw new ProductNotFoundException("Not found");
        }

        product.setDescription(description);
        product.setPrice(price);
        product.setTitle(title);
        productRepository.save(product);

        return new Success(200, "Product updated");
    }

    public Object delete(Integer id){
        productRepository.deleteById(id);
        return new Success(200, "Product deleted");
    }
}
