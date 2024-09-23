package com.shop.espringshop.service;

import com.shop.espringshop.exception.ProductException;
import com.shop.espringshop.model.Review;
import com.shop.espringshop.model.User;
import com.shop.espringshop.request.ReviewRequest;

import java.util.List;

public interface ReviewService {
    public Review createReview(ReviewRequest req, User user) throws ProductException;
    public List<Review> getAllProductsReview(Long productId);
}
