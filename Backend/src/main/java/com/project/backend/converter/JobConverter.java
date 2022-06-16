package com.project.backend.converter;

import com.project.backend.dto.JobDto;
import com.project.backend.entity.Job;

public class JobConverter {

    public Job dtoToEntity(JobDto jobDto) {
        Job job = new Job();

        job.setName(jobDto.getName());
        job.setCategory(jobDto.getCategory());
        job.setDescription(jobDto.getDescription());
        job.setExperience(jobDto.getExperience());
        job.setSalary(jobDto.getSalary());
        job.setEmployerId(jobDto.getEmployerId());

        return job;
    }

    public JobDto entityToDto(Job job) {
        JobDto jobDto = new JobDto();
        JobConverter jobConverter = new JobConverter();

        jobDto.setName(job.getName());
        jobDto.setCategory(job.getCategory());
        jobDto.setDescription(job.getDescription());
        jobDto.setExperience(job.getExperience());
        jobDto.setSalary(job.getSalary());
        jobDto.setEmployerId(job.getEmployerId());

        return jobDto;
    }

}