package com.campus.campus.myPageReview;

import com.campus.campus.review.Review;
import com.campus.campus.review.ReviewRepository;
import org.springframework.stereotype.Service;

@Service
public class MyPageReviewService {

    private final ReviewRepository reviewRepository;

    public MyPageReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public MyPageReviewResponseDto findReview(Long reviewId) {

        Review findReview = reviewRepository.findById(reviewId).orElseThrow(IllegalArgumentException::new);

        String roomName = "사이트B";

        String nickName = reviewRepository.findNickNamesByMemberId(findReview.getMemberId());

        return MyPageReviewResponseDto.of(findReview, roomName, nickName);

    }
}
