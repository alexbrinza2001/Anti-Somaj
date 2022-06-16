package com.project.backend.service;

import com.project.backend.converter.EmployerConverter;
import com.project.backend.converter.FreelancerConverter;
import com.project.backend.converter.UserConverter;
import com.project.backend.dto.FreelancerDto;
import com.project.backend.dto.UserDto;
import com.project.backend.entity.Freelancer;
import com.project.backend.entity.User;
import com.project.backend.repo.FreelancerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FreelancerService {

    @Autowired
    FreelancerRepo freelancerRepository;

    public void addFreelancer(FreelancerDto freelancerDto) {
        FreelancerConverter freelancerConverter = new FreelancerConverter();

        Freelancer freelancer = freelancerConverter.dtoToEntity(freelancerDto);

        freelancerRepository.save(freelancer);
    }

    public List<FreelancerDto> getFreelancers() {
        FreelancerConverter freelancerConverter = new FreelancerConverter();

        List<Freelancer> freelancerList = freelancerRepository.findAll();

        return freelancerList.stream().map(freelancerConverter::entityToDto).collect(Collectors.toList());
    }

}
