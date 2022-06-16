package com.project.backend.service;

import com.project.backend.converter.EmployerConverter;
import com.project.backend.converter.FreelancerConverter;
import com.project.backend.dto.EmployerDto;
import com.project.backend.dto.FreelancerDto;
import com.project.backend.entity.Employer;
import com.project.backend.entity.Freelancer;
import com.project.backend.repo.EmployerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployerService {

    @Autowired
    EmployerRepo employerRepository;

    public void addEmployer(EmployerDto employerDto) {
        EmployerConverter employerConverter = new EmployerConverter();

        Employer employer = employerConverter.dtoToEntity(employerDto);

        employerRepository.save(employer);
    }

    public List<EmployerDto> getEmployers() {
        EmployerConverter employerConverter = new EmployerConverter();

        List<Employer> employerList = employerRepository.findAll();

        return employerList.stream().map(employerConverter::entityToDto).collect(Collectors.toList());
    }

}
