package com.project.backend.repo;

import com.project.backend.entity.Freelancer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FreelancerRepo extends JpaRepository<Freelancer, Integer> {
    List<Freelancer> findByDescriptionIs(String description);
}