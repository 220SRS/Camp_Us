package com.campus.campus.myPageReview;

import com.campus.campus.review.Review;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MyPageReviewResponseDto {

    private Float stars;

    private LocalDate createdAt;

    private String roomName; //방 이름

    private String nickName; // 유저 닉네임

    private String comment;

    public static MyPageReviewResponseDto of(Review findReview, String roomName, String nickName) {
        MyPageReviewResponseDto reviewResponseDto = new MyPageReviewResponseDto();

        reviewResponseDto.setStars(findReview.getStars());
        reviewResponseDto.setCreatedAt(findReview.getCreatedAt());
        reviewResponseDto.setComment(findReview.getComment());

        reviewResponseDto.setRoomName(roomName);
        reviewResponseDto.setNickName(nickName);

        return reviewResponseDto;
    }
}
