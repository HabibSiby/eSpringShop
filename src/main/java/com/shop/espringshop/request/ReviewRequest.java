package com.shop.espringshop.request;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewRequest {
    private Long productId;
    private String review;
}
