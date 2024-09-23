package com.shop.espringshop.request;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddItemRequest {
    private Long productId;
    private String size;
    private int quantity;
    private Integer price;
}
