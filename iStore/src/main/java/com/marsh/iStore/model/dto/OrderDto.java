package com.marsh.iStore.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private Double price;
    private Integer quantity;
    private Integer orderId;
    private Integer productId;
    private Integer userId;

}
