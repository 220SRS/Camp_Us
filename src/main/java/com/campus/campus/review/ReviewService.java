package com.campus.campus.review;

import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public ReviewResponseDto saveReview(ReviewSaveDto reviewSaveDto) {
        Review review = Review.of(reviewSaveDto);

        reviewRepository.save(review);

        return ReviewResponseDto.of(review);
    }
}
