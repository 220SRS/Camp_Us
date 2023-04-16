package com.campus.campus.review;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/myPage/review")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public ResponseEntity<ReviewResponseDto> saveReview(@RequestBody ReviewSaveDto reviewSaveDto) {
        ReviewResponseDto reviewResponseDto = reviewService.saveReview(reviewSaveDto);

        return ResponseEntity.ok(reviewResponseDto);
    }
}
