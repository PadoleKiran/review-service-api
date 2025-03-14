package com.devgen.review_service.repository;

import com.devgen.review_service.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {
    List<Review> findAllByProductId(Long productId);

    void deleteByProductIdAndReviewId(Long productId, Long reviewId);

}
