package com.project.backend.controller;

import com.project.backend.dto.JobDto;
import com.project.backend.dto.ReviewDto;
import com.project.backend.service.ResourceAccessService;
import com.project.backend.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewController {

    @Autowired
    ReviewService reviewService;
    @Autowired
    ResourceAccessService resourceAccessService;

    @Secured({"ROLE_USER", "ROLE_COMPANY", "ROLE_ADMIN"})
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
    @DeleteMapping("/deleteReview")
    @Secured({"ROLE_USER", "ROLE_COMPANY", "ROLE_ADMIN"})
    @ResponseBody
    public ResponseEntity<ReviewDto> deleteReview(@RequestParam(value = "id") Integer reviewId, Authentication authentication){
        ReviewDto reviewDto = reviewService.getReview(reviewId);

        if (reviewDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if(resourceAccessService.checkAccessJob(authentication, reviewId)) {
            reviewService.deleteReview(reviewDto);
            return ResponseEntity.ok(reviewDto);
        }
        else return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body(reviewDto);
    }

}
