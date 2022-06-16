package com.project.backend.controller;

import com.project.backend.dto.FreelancerDto;
import com.project.backend.dto.UserDto;
import com.project.backend.service.FreelancerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FreelancerController {

    @Autowired
    FreelancerService freelancerService;

    @PostMapping("/freelancer")
    public ResponseEntity<FreelancerDto> addFreelancer(@RequestBody FreelancerDto freelancerDto) {

        freelancerService.addFreelancer(freelancerDto);

        return ResponseEntity.ok(freelancerDto);
    }

    @GetMapping("/freelancers")
    public ResponseEntity<List<FreelancerDto>> getFreelancers() {
        List<FreelancerDto> freelancerDtoList = freelancerService.getFreelancers();

        for (FreelancerDto freelancerDto : freelancerDtoList) {
            if (freelancerDto.getDescription().length() < 50)
                return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }

        return ResponseEntity.ok(freelancerDtoList);
    }

}
