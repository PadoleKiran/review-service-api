package com.devgen.review_service.controller;

import com.devgen.review_service.model.Review;
import com.devgen.review_service.service.IReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ReviewController {
    private final IReviewsService reviewsService;

    @Autowired
    public ReviewController(IReviewsService reviewsService){
        this.reviewsService = reviewsService;
    }

    @GetMapping("/{productId}/reviews")
    public ResponseEntity<List<Review>> getReviewByProductId(@PathVariable Long productId){
        return ResponseEntity.status(HttpStatus.OK).body(reviewsService.getReviewsByProductId(productId));
    }

    @PostMapping("/{productId}/reviews")
    public ResponseEntity<List<Review>> addReview(@PathVariable Long productId, @RequestBody Review review){
        review.setProductId(productId);
        reviewsService.addReview(review);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{productId}/reviews/{reviewId}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long productId, @PathVariable Long reviewId) {
        reviewsService.deleteReview(productId, reviewId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
