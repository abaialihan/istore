package com.marsh.iStore.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "products")
@Data
public class Product extends BaseEntity {

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private String price;

    @Column(name = "image")
    private String image;

    public Product() {
    }

    public Product(String title, String description, String price, String image) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.image = image;
    }
}
