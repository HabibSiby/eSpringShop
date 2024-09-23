package com.shop.espringshop.service.impl;

import com.shop.espringshop.exception.ProductException;
import com.shop.espringshop.model.Product;
import com.shop.espringshop.model.Review;
import com.shop.espringshop.model.User;
import com.shop.espringshop.repository.ReviewRepository;
import com.shop.espringshop.request.ReviewRequest;
import com.shop.espringshop.service.ProductService;
import com.shop.espringshop.service.ReviewService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReviewServiceImplementation implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final ProductService productService;

    public ReviewServiceImplementation(final ReviewRepository reviewRepository,
                                       final ProductService productService) {
        this.reviewRepository = reviewRepository;
        this.productService = productService;
    }
    @Override
    public Review createReview(ReviewRequest req, User user) throws ProductException {

        Product product = productService.findProductById(req.getProductId());

        Review review = new Review();
        review.setProduct(product);
        review.setUser(user);
        review.setReview(req.getReview());
        review.setCreatedAt(LocalDateTime.now());

        return reviewRepository.save(review);
    }

    @Override
    public List<Review> getAllProductsReview(Long productId) {
        return reviewRepository.getAllProductsReview(productId);
    }
}
