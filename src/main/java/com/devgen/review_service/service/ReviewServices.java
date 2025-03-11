package com.devgen.review_service.service;

import com.devgen.review_service.model.Review;
import com.devgen.review_service.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServices implements IReviewsService{

    private final ReviewRepository reviewRepository;

    public ReviewServices(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getReviewsByProductId(Long productId) {
        return reviewRepository.findAllByProductId(productId);
    }

    @Override
    public void addReview(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public void deleteReview(Long productId, Long reviewId) {
        reviewRepository.deleteById(reviewId);
    }
}
