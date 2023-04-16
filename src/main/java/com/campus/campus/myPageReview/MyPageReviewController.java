package com.campus.campus.myPageReview;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/myPage/ReviewList")
public class MyPageReviewController {

    private final MyPageReviewService myReviewService;

    public MyPageReviewController(MyPageReviewService myReviewService) {
        this.myReviewService = myReviewService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<MyPageReviewResponseDto> findReview(@PathVariable("id") Long reviewId) {
        MyPageReviewResponseDto responseDto = myReviewService.findReview(reviewId);

        return ResponseEntity.ok(responseDto);
    }
}
