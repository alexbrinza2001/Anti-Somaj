package com.project.backend.service;

import com.project.backend.converter.EmployerConverter;
import com.project.backend.converter.FreelancerConverter;
import com.project.backend.converter.ReviewConverter;
import com.project.backend.dto.ReviewDto;
import com.project.backend.entity.Review;
import com.project.backend.repo.EmployerRepo;
import com.project.backend.repo.FreelancerRepo;
import com.project.backend.repo.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewService {

    @Autowired
    ReviewRepo reviewRepository;

    @Autowired
    EmployerRepo employerRepository;

    @Autowired
    FreelancerRepo freelancerRepository;

    public void addReview(ReviewDto reviewDto) {
        ReviewConverter reviewConverter = new ReviewConverter();

        reviewRepository.save(reviewConverter.dtoToEntity(reviewDto));
    }

    public List<ReviewDto> getReviews() {
        ReviewConverter reviewConverter = new ReviewConverter();
        EmployerConverter employerConverter = new EmployerConverter();
        FreelancerConverter freelancerConverter = new FreelancerConverter();

        List<Review> reviewList = reviewRepository.findAll();
        List<ReviewDto> reviews = new ArrayList<ReviewDto>();

        for (Review Review : reviewList) {
            ReviewDto reviewDto = reviewConverter.entityToDto(Review);

            reviews.add(reviewDto);
        }

        return reviews;
    }

}