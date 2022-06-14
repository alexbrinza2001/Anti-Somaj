package com.project.backend.controller;

import com.project.backend.dto.FreelancerDto;
import com.project.backend.service.FreelancerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FreelancerController {

    @Autowired
    FreelancerService freelancerService;

    @PostMapping("/freelancer")
    public ResponseEntity<FreelancerDto> addFreelancer(@RequestBody FreelancerDto freelancerDto) {

        freelancerService.addFreelancer(freelancerDto);

        return ResponseEntity.ok(freelancerDto);
    }

}
