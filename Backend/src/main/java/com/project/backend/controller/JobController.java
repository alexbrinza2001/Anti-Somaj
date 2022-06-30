package com.project.backend.controller;

import com.project.backend.dto.JobDto;
import com.project.backend.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/job")
    @Secured("ROLE_COMPANY")
    @ResponseBody
    public ResponseEntity<JobDto> deleteJob(@RequestParam(value = "id") Integer jobId){
        JobDto jobDto = jobService.getJob(jobId);

        if (jobDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        jobService.deleteJob(jobDto);

        return ResponseEntity.ok(jobDto);
    }
}
