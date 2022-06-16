package com.project.backend.repo;

import com.project.backend.entity.BugReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BugReportRepo extends JpaRepository<BugReport, Integer> {
}
