package com.project.backend.service;

import com.project.backend.converter.EmployerConverter;
import com.project.backend.dto.EmployerDto;
import com.project.backend.entity.Employer;
import com.project.backend.repo.EmployerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployerService {

    @Autowired
    EmployerRepo employerRepository;

    public void addEmployer(EmployerDto employerDto) {
        EmployerConverter employerConverter = new EmployerConverter();

        Employer employer = employerConverter.dtoToEntity(employerDto);

        employerRepository.save(employer);
    }

}
