package com.devgen.review_service.service;

import com.devgen.review_service.model.Review;

import java.util.List;

public interface IReviewsService {
    List<Review> getReviewsByProductId(Long productId);
    void addReview(Review review);
    void deleteReview(Long productId, Long reviewId);

}
