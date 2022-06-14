package com.project.backend.converter;

import com.project.backend.dto.ReviewDto;
import com.project.backend.entity.Review;

public class ReviewConverter {

    public Review dtoToEntity(ReviewDto reviewDto) {
        Review review = new Review();

        review.setDescription(reviewDto.getDescription());
        review.setTitle(reviewDto.getTitle());
        review.setRating(reviewDto.getRating());

        return review;
    }

    public ReviewDto entityToDto(Review review) {
        ReviewDto reviewDto = new ReviewDto();
        FreelancerConverter freelancerConverter = new FreelancerConverter();
        EmployerConverter employerConverter = new EmployerConverter();

        reviewDto.setEmail(review.getEmail());
        reviewDto.setTitle(review.getTitle());
        reviewDto.setRating(review.getRating());

        return reviewDto;
    }

}