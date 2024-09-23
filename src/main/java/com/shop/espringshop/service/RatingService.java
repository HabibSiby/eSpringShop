package com.shop.espringshop.service;

import com.shop.espringshop.exception.ProductException;
import com.shop.espringshop.model.Rating;
import com.shop.espringshop.model.User;
import com.shop.espringshop.request.RatingRequest;

import java.util.List;


public interface RatingService {

    public Rating createRating(RatingRequest req, User user) throws ProductException;
    public List<Rating> getProductsRating(Long productId);
}
