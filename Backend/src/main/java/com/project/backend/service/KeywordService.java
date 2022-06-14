package com.project.backend.service;

import com.project.backend.converter.JobConverter;
import com.project.backend.converter.KeywordConverter;
import com.project.backend.dto.KeywordDto;
import com.project.backend.entity.Job;
import com.project.backend.entity.Keyword;
import com.project.backend.repo.JobRepo;
import com.project.backend.repo.KeywordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KeywordService {

    @Autowired
    KeywordRepo keywordRepository;

    @Autowired
    JobRepo jobRepository;

    public void addKeyword(KeywordDto keywordDto) {
        KeywordConverter keywordConverter = new KeywordConverter();
        JobConverter jobConverter = new JobConverter();

        String jobName = keywordDto.getJob().getName();
        jobRepository.save(jobConverter.dtoToEntity(keywordDto.getJob()));
        Job job = jobRepository.findByNameIs(jobName).get(0);

        Keyword Keyword = keywordConverter.dtoToEntity(keywordDto);
        Keyword.setJobId(job.getJobId());

        keywordRepository.save(Keyword);
    }

    public List<KeywordDto> getKeywords() {
        KeywordConverter keywordConverter = new KeywordConverter();
        JobConverter jobConverter = new JobConverter();

        List<Keyword> keywordList = keywordRepository.findAll();
        List<KeywordDto> keywords = new ArrayList<keywordDto>();

        for (Keyword Keyword : keywordList) {
            KeywordDto keywordDto = keywordConverter.entityToDto(Keyword);
            keywordDto.setJob(jobConverter.entityToDto(jobRepository.getById(Keyword.getJobId())));

            keywords.add(keywordDto);
        }

        return keywords;
    }

}