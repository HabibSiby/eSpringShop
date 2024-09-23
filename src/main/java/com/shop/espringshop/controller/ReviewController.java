package com.shop.espringshop.controller;

import com.shop.espringshop.exception.ProductException;
import com.shop.espringshop.exception.UserException;
import com.shop.espringshop.model.Review;
import com.shop.espringshop.model.User;
import com.shop.espringshop.request.ReviewRequest;
import com.shop.espringshop.service.ReviewService;
import com.shop.espringshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<Review> createReview(@RequestBody ReviewRequest req,
                                               @RequestHeader("Authorization") String jwt) throws UserException, ProductException {

        User user = userService.findUserProfileByJwt(jwt);
        Review review = reviewService.createReview(req, user);

        return new ResponseEntity<>(review, HttpStatus.CREATED);
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<Review>> getProductsReview(@PathVariable Long productId,
                                                          @RequestHeader("Authorization") String jwt) throws UserException, ProductException {

        User user = userService.findUserProfileByJwt(jwt);
        List<Review> review = reviewService.getAllProductsReview(productId);

        return new ResponseEntity<>(review, HttpStatus.ACCEPTED);
    }

}
