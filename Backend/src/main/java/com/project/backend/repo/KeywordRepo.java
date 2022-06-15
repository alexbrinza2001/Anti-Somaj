package com.project.backend.repo;

import com.project.backend.entity.Keyword;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeywordRepo extends JpaRepository<Keyword, Integer> {
}
