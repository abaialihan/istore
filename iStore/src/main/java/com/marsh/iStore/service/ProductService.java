package com.marsh.iStore.service;

import com.marsh.iStore.entity.Product;
import com.marsh.iStore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // возвращает вес список продукта
    public List<Product> getListAllProduct(){
        return productRepository.findAll();
    }

    // поиск по названию
    public List<Product> getListByTitle(String title){
        return productRepository.findByTitle(title);
    }

    // по id
    public Product get(Integer id){
        return productRepository.findById(id).orElse(null);
    }

    public void save(Product product){
        productRepository.save(product);
    }

    public void delete(Integer id){
        productRepository.deleteById(id);
    }
}
