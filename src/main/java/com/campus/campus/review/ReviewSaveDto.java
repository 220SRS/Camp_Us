package com.campus.campus.review;

import lombok.Getter;

@Getter
public class ReviewSaveDto {

    private Long memberId;

    private Long rsvId;

    private Float stars;

    private String comment;


}
