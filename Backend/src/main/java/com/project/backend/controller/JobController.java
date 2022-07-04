package com.project.backend.controller;

import com.project.backend.dto.JobDto;
import com.project.backend.service.JobService;
import com.project.backend.service.ResourceAccessService;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {

    @Autowired
    JobService jobService;
    @Autowired
    ResourceAccessService resourceAccessService;

    @PostMapping("/job")
    @Secured("ROLE_COMPANY")
    public ResponseEntity<JobDto> addJob(@RequestBody JobDto jobDto) {
        jobService.addJob(jobDto);

        return ResponseEntity.ok(jobDto);
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<JobDto>> getJobs() {
        List<JobDto> jobList = jobService.getJobs();

        return ResponseEntity.ok(jobList);
    }

    @DeleteMapping("/deleteJob")
    @Secured("ROLE_COMPANY")
    @ResponseBody
    public ResponseEntity<JobDto> deleteJob(@RequestParam(value = "id") Integer jobId, Authentication authentication){
        JobDto jobDto = jobService.getJob(jobId);

        if (jobDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        System.out.println(123);
        if(resourceAccessService.checkAccessJob(authentication, jobId)) {
            jobService.deleteJob(jobDto);
            return ResponseEntity.ok(jobDto);
        }
        else return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body(jobDto);
    }
}
