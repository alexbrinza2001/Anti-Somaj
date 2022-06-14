package com.project.backend.controller;

import com.project.backend.dto.JobDto;
import com.project.backend.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JobController {

    @Autowired
    JobService jobService;

    @PostMapping("/job")
    public ResponseEntity<JobDto> addJob(@RequestBody JobDto jobDto) {
        jobService.addJob(jobDto);

        return ResponseEntity.ok(jobDto);
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<JobDto>> getJobs() {
        List<JobDto> jobList = jobService.getJobs();

        return ResponseEntity.ok(jobList);
    }

}
