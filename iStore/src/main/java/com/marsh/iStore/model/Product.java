package com.marsh.iStore.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
@Data
public class Product extends BaseEntity {

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Double price;

    @Column(name = "image")
    private String image;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    private User userId;

    @ManyToMany
    private List<Order> order;

    public Product() {
    }

    public Product(String title, String description, Double price, String image, User user) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.image = image;
        this.userId = user;
    }

    public String getUserName(){
        return userId != null ? userId.getUsername() : "none" ;
    }
}
