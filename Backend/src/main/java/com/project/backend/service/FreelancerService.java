package com.project.backend.service;

import com.project.backend.converter.FreelancerConverter;
import com.project.backend.dto.FreelancerDto;
import com.project.backend.entity.Freelancer;
import com.project.backend.repo.FreelancerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FreelancerService {

    @Autowired
    FreelancerRepo freelancerRepository;

    public void addFreelancer(FreelancerDto freelancerDto) {
        FreelancerConverter freelancerConverter = new FreelancerConverter();

        Freelancer freelancer = freelancerConverter.dtoToEntity(freelancerDto);

        freelancerRepository.save(freelancer);
    }

}
