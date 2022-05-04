package com.marsh.iStore.dto;

import lombok.Data;

@Data
public class OrderDto {
    private Double price;
    private Integer quantity;
    private Integer orderId;
    private Integer productId;
    private Integer userId;

    public OrderDto() {
    }

    public OrderDto(Double price, Integer quantity, Integer orderId, Integer productId, Integer userId) {
        this.price = price;
        this.quantity = quantity;
        this.orderId = orderId;
        this.productId = productId;
        this.userId = userId;
    }
}
