package com.marsh.iStore.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
public class Order extends BaseEntity{

    @Column(name = "total_price")
    private Double total_price;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "order_id", referencedColumnName = "id", insertable = false, updatable = false)
    private List<OrderItem> order_items;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    private User user_id;

    public Order() {
    }

    public Order(Double total_price, List<OrderItem> order_items, User user_id) {
        this.total_price = total_price;
        this.order_items = order_items;
        this.user_id = user_id;
    }
}
