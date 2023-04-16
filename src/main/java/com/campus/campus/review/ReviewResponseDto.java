package com.campus.campus.review;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ReviewResponseDto {

    private Long reviewId;

    private Long memberId;

    private Float stars;

    private String comment;

    private LocalDate createdAt;

    public static ReviewResponseDto of(Review review) {
        ReviewResponseDto reviewResponseDto = new ReviewResponseDto();

        reviewResponseDto.setReviewId(review.getReviewId());
        reviewResponseDto.setMemberId(review.getMemberId());
        reviewResponseDto.setStars(review.getStars());
        reviewResponseDto.setComment(review.getComment());
        reviewResponseDto.setCreatedAt(review.getCreatedAt());

        return reviewResponseDto;
    }
}
