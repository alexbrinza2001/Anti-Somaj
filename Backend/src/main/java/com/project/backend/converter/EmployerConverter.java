package com.project.backend.converter;

import com.project.backend.dto.EmployerDto;
import com.project.backend.entity.Employer;

public class EmployerConverter {

    public Employer dtoToEntity(EmployerDto employerDto) {
        Employer employer = new Employer();

        employer.setDescription(employerDto.getDescription());
        employer.setName(employerDto.getName());
        employer.setLocation(employerDto.getLocation());

        return employer;
    }

    public EmployerDto entityToDto(Employer employer) {
        EmployerDto employerDto = new EmployerDto();

        employerDto.setName(employer.getName());
        employerDto.setDescription(employer.getDescription());
        employerDto.setLocation(employer.getLocation());

        return employerDto;
    }

}
