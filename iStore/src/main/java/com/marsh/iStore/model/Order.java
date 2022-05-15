package com.marsh.iStore.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="orders")
@EntityListeners(AuditingEntityListener.class)
@Data
public class Order{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @CreatedDate
    @Column(name = "created_date")
    private Date created_date;

    @LastModifiedDate
    @Column(name = "updated_date")
    private Date updated_date;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price")
    private Double price;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Product product;

    public Order() {
    }

    public Order(Integer quantity, User user, Integer productId){
        this.quantity = quantity;
        this.user = user;
        this.productId = productId;
    }

}
