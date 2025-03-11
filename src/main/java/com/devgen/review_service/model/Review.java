package com.devgen.review_service.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "reviews")
@Data
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;
    private Long productId;

    private short ratings;
    private int userId;
    private String title;
    private String description;

    // Auditing
    private String createdBy;
    private String updatedBy;
    private LocalDateTime createOn;
    private LocalDateTime updatedAt;
}
