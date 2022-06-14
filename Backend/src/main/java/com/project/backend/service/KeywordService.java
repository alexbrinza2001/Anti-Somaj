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

        keywordRepository.save(keywordConverter.dtoToEntity(keywordDto));
    }

    public List<KeywordDto> getKeywords() {
        KeywordConverter keywordConverter = new KeywordConverter();


        List<Keyword> keywordList = keywordRepository.findAll();
        List<KeywordDto> keywords = new ArrayList<KeywordDto>();

        for (Keyword Keyword : keywordList) {
            KeywordDto keywordDto = keywordConverter.entityToDto(Keyword);

            keywords.add(keywordDto);
        }

        return keywords;
    }

}