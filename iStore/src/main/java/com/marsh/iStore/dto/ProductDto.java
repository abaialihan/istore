package com.marsh.iStore.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class ProductDto {

    private Integer id;
    private String title;
    private String description;
    private Double price;
    private String imageUrl;

    public ProductDto() {
    }

    public ProductDto(Integer id, String title, String description, Double price, String imageUrl) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
    }
}
