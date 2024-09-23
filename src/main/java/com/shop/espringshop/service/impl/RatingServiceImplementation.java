package com.shop.espringshop.service.impl;

import com.shop.espringshop.exception.ProductException;
import com.shop.espringshop.model.Product;
import com.shop.espringshop.model.Rating;
import com.shop.espringshop.model.User;
import com.shop.espringshop.repository.RatingRepository;
import com.shop.espringshop.request.RatingRequest;
import com.shop.espringshop.service.ProductService;
import com.shop.espringshop.service.RatingService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RatingServiceImplementation implements RatingService {

    private final RatingRepository ratingRepository;
    private final ProductService productService;

    public RatingServiceImplementation(final RatingRepository ratingRepository,
                                       final ProductService productService) {
        this.ratingRepository = ratingRepository;
        this.productService = productService;
    }
    @Override
    public Rating createRating(RatingRequest req, User user) throws ProductException {

        Product product = productService.findProductById(req.getProductId());

        Rating rating = new Rating();
        rating.setProduct(product);
        rating.setUser(user);
        rating.setRating(req.getRating());
        rating.setCreatedAt(LocalDateTime.now());

        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getProductsRating(Long productId) {

        return ratingRepository.getAllProductsRating(productId);
    }
}
