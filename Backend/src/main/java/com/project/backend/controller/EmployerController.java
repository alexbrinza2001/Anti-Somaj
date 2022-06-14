package com.project.backend.controller;

import com.project.backend.dto.EmployerDto;
import com.project.backend.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployerController {

    @Autowired
    EmployerService employerService;

    @PostMapping("/employer")
    public ResponseEntity<EmployerDto> addEmployer(EmployerDto employerDto) {
        employerService.addEmployer(employerDto);

        return ResponseEntity.ok(employerDto);
    }

}

