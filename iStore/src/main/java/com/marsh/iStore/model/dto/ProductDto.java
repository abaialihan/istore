package com.marsh.iStore.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductDto {

    private Integer id;
    private String title;
    private String description;
    private Double price;
    private String imageUrl;

}
