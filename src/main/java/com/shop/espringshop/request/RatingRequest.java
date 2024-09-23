package com.shop.espringshop.request;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RatingRequest {
    private Long productId;
    private double rating;
}
