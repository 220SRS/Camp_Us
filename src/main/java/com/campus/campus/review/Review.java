package com.campus.campus.review;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    private Long memberId;

    private Long rsvId;

    private Float stars;

    private String comment;

    private LocalDate createdAt = LocalDate.now();

    private byte[] image1;
    private byte[] image2;
    private byte[] image3;
    private byte[] image4;
    private byte[] image5;

    public static Review of(ReviewSaveDto reviewSaveDto) {
        Review review = new Review();

        review.setMemberId(reviewSaveDto.getMemberId());
        review.setRsvId(reviewSaveDto.getRsvId());
        review.setStars(reviewSaveDto.getStars());
        review.setComment(reviewSaveDto.getComment());

        return review;
    }
}
