package com.project.backend.converter;

import com.project.backend.dto.JobDto;
import com.project.backend.entity.Job;

public class JobConverter {

    public Job dtoToEntity(JobDto JobDto) {
        Job job = new Job();

        job.setName(jobDto.getName());

        return job;
    }

    public JobDto entityToDto(Job job) {
        JobDto jobDto = new JobDto();
        JobConverter jobConverter = new JobConverter();

        jobDto.setName(job.getName());

        return jobDto;
    }

}