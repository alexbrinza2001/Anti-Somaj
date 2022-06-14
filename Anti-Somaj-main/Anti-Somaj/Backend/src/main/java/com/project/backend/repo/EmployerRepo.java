package com.project.backend.repo;

import com.project.backend.entity.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployerRepo extends JpaRepository<Employer, Integer> {
    List<Employer> findByNameIs(String name);
}
