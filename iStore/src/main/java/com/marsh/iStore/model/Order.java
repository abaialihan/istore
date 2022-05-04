package com.marsh.iStore.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="orders")
@Data
public class Order extends BaseEntity{

    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price")
    private  Integer price;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @OneToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Product product;

    public Order() {
    }

    public Order(Integer userId, Integer productId, Integer quantity, Integer price){
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }

}
