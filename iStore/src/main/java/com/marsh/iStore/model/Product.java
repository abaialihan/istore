package com.marsh.iStore.model;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

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
    private User user_id;

    public Product() {
    }

    public Product(String title, String description, Double price, String image, User user) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.image = image;
        this.user_id = user;
    }

    public String getUserName(){
        return user_id != null ? user_id.getUsername() : "none" ;
    }
}
