package com.project.backend.service;

import com.project.backend.converter.EmployerConverter;
import com.project.backend.converter.FreelancerConverter;
import com.project.backend.converter.ReviewConverter;
import com.project.backend.dto.ReviewDto;
import com.project.backend.entity.Employer;
import com.project.backend.entity.Freelancer;
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
        FreelancerConverter freelancerConverter = new FreelancerConverter();
        EmployerConverter employerConverter = new EmployerConverter();

        String employerName = reviewDto.getEmployer().getName();
        employerRepository.save(employerConverter.dtoToEntity(reviewDto.getEmployer()));
        Employer employer = employerRepository.findByNameIs(employerName).get(0);

        String freelancerDescription = reviewDto.getFreelancer().getDescription();
        freelancerRepository.save(freelancerConverter.dtoToEntity(reviewDto.getFreelancer()));
        Freelancer freelancer = freelancerRepository.findByDescriptionIs(freelancerDescription).get(0);

        Review Review = reviewConverter.dtoToEntity(reviewDto);
        Review.setEmployerId(employer.getEmployerId());
        Review.setFreelancerId(freelancer.getFreelancerId());

        reviewRepository.save(Review);
    }

    public List<ReviewDto> getReviews() {
        ReviewConverter reviewConverter = new ReviewConverter();
        EmployerConverter employerConverter = new EmployerConverter();
        FreelancerConverter freelancerConverter = new FreelancerConverter();

        List<Review> reviewList = reviewRepository.findAll();
        List<ReviewDto> reviews = new ArrayList<reviewDto>();

        for (Review Review : reviewList) {
            ReviewDto reviewDto = reviewConverter.entityToDto(Review);
            reviewDto.setEmployer(employerConverter.entityToDto(employerRepository.getById(Review.getEmployerId())));
            reviewDto.setFreelancer(freelancerConverter.entityToDto(freelancerRepository.getById(Review.getFreelancerId())));

            reviews.add(reviewDto);
        }

        return reviews;
    }

}