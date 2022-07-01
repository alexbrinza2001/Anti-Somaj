package com.project.backend.service;

import com.project.backend.converter.ReviewConverter;
import com.project.backend.dto.JobDto;
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

    ReviewConverter reviewConverter = new ReviewConverter();


    public void addReview(ReviewDto reviewDto) {
        ReviewConverter reviewConverter = new ReviewConverter();

        reviewRepository.save(reviewConverter.dtoToEntity(reviewDto));
    }

    public List<ReviewDto> getReviews() {
        ReviewConverter reviewConverter = new ReviewConverter();

        List<Review> reviewList = reviewRepository.findAll();
        List<ReviewDto> reviews = new ArrayList<ReviewDto>();

        for (Review Review : reviewList) {
            ReviewDto reviewDto = reviewConverter.entityToDto(Review);

            reviews.add(reviewDto);
        }

        return reviews;
    }

    public ReviewDto getReview(Integer id){
        try {
            return reviewConverter.entityToDto(reviewRepository.getById(id));
        }
        catch (Exception e) {
            return null;
        }
    }
    public void deleteReview(ReviewDto reviewDto) {
        reviewRepository.delete(reviewConverter.dtoToEntity(reviewDto));
    }
}