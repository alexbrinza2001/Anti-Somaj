package com.project.backend.service;

import com.project.backend.entity.Job;
import com.project.backend.entity.Review;
import com.project.backend.entity.User;
import com.project.backend.repo.JobRepo;
import com.project.backend.repo.ReviewRepo;
import com.project.backend.repo.UserRepo;
import org.hibernate.annotations.NaturalId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.nio.file.AccessDeniedException;

@Component
public class ResourceAccessService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    JobRepo jobRepo;
    @Autowired
    ReviewRepo reviewRepo;
    public Boolean checkAccessJob(Authentication authentication, Integer id){
        String email = authentication.getName();
        User user = userRepo.findByEmail(email);
        Job job = jobRepo.getById(id);
        if(job.getEmployerId() == user.getEmployerId()){
            return true;
        }
        return false;
    }
    public Boolean checkAccessReview(Authentication authentication, Integer id){
        String email = authentication.getName();
        User user = userRepo.findByEmail(email);
        Review review = reviewRepo.getById(id);
        if(user.getEmployerId() == review.getEmployerId() || user.getFreelancerId() == review.getFreelancerId()){
            return true;
        }
        return false;
    }
}
