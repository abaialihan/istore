package com.marsh.iStore.repository;

import com.marsh.iStore.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findAllByUserId(Integer userId);

    @Query(value = "SELECT * FROM orders o", nativeQuery = true)
    List<Order> findAllOrder();

}
