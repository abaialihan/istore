package com.marsh.iStore.repository;

import com.marsh.iStore.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByTitle(String title);

}
