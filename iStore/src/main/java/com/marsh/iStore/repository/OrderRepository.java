package com.marsh.iStore.repository;

import com.marsh.iStore.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findAllByUserIdOrderByCreatedDateDesc(Integer user_id);
}
