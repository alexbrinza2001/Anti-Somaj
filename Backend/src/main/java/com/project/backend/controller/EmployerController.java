package com.project.backend.controller;

import com.project.backend.dto.EmployerDto;
import com.project.backend.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployerController {

    @Autowired
    EmployerService employerService;

    @PostMapping("/employer")
    public ResponseEntity<EmployerDto> addEmployer(EmployerDto employerDto) {
        employerService.addEmployer(employerDto);

        return ResponseEntity.ok(employerDto);
    }

    @GetMapping("/employers")
    public ResponseEntity<List<EmployerDto>> getFreelancers() {
        List<EmployerDto> employerDtos = employerService.getEmployers();

        for (EmployerDto employerDto : employerDtos) {

            char[] nameCharacters = employerDto.getName().toCharArray();

            for (char character : nameCharacters) {
                if (character >= '0' && character <= '9') {
                    return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
                }
            }
        }

        return ResponseEntity.ok(employerDtos);
    }

}

