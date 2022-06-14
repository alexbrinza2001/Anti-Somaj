package com.project.backend.converter;

import com.project.backend.dto.FreelancerDto;
import com.project.backend.entity.Freelancer;

public class FreelancerConverter {

    public Freelancer dtoToEntity(FreelancerDto freelancerDto) {
        Freelancer freelancer = new Freelancer();

        freelancer.setDescription(freelancerDto.getDescription());
        freelancer.setEducation(freelancerDto.getEducation());
        freelancer.setLocation(freelancerDto.getLocation());
        freelancer.setCvLink(freelancerDto.getCvLink());

        return freelancer;
    }

    public FreelancerDto entityToDto(Freelancer freelancer) {
        FreelancerDto freelancerDto = new FreelancerDto();

        freelancerDto.setDescription(freelancer.getDescription());
        freelancerDto.setEducation(freelancer.getEducation());
        freelancerDto.setLocation(freelancer.getLocation());
        freelancerDto.setCvLink(freelancer.getCvLink());

        return freelancerDto;
    }

}