package com.marsh.iStore.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="order_items")
@Data
public class OrderItem  extends BaseEntity{

    @Column(name = "product_id")
    private @NotNull Integer product_id;

    @Column(name = "quantity")
    private@NotNull Integer quantity;

    @Column(name = "price")
    private @NotNull Integer price;

    @Column(name = "order_id")
    private @NotNull Integer order_id;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Order order;

    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Product product;

    public OrderItem() {
    }

    public OrderItem(Integer product_id, Integer quantity, Integer price, Integer order_id, Order order, Product product) {
        this.product_id = product_id;
        this.quantity = quantity;
        this.price = price;
        this.order_id = order_id;
        this.order = order;
        this.product = product;
    }
}
