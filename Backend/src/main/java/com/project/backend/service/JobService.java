package com.project.backend.service;

import com.project.backend.converter.JobConverter;
import com.project.backend.dto.JobDto;
import com.project.backend.entity.Job;
import com.project.backend.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobService {

    @Autowired
    JobRepo jobRepository;


    public void addJob(JobDto jobDto) {
        JobConverter jobConverter = new JobConverter();
        Job Job = jobConverter.dtoToEntity(jobDto);

        jobRepository.save(Job);
    }

    public List<JobDto> getJobs() {
        JobConverter jobConverter = new JobConverter();

        List<Job> jobList = jobRepository.findAll();
        List<JobDto> jobs = new ArrayList<JobDto>();

        for (Job Job : jobList) {
            JobDto jobDto = jobConverter.entityToDto(Job);

            jobs.add(jobDto);
        }

        return jobs;
    }

}