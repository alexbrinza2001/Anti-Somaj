package com.project.backend.controller;

import com.project.backend.dto.ReviewDto;
import com.project.backend.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @PostMapping("/review")
    public ResponseEntity<ReviewDto> addReview(@RequestBody ReviewDto reviewDto) {
        reviewService.addReview(reviewDto);

        return ResponseEntity.ok(reviewDto);
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<ReviewDto>> getReviews() {
        List<ReviewDto> reviewList = reviewService.getReviews();

        for (ReviewDto reviewDto : reviewList) {
            if (reviewDto.getRating() > 100 || reviewDto.getRating() < 0) {
                return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
            }
        }

        return ResponseEntity.ok(reviewList);
    }

}
