package com.project.backend.converter;

import com.project.backend.dto.KeywordDto;
import com.project.backend.entity.Keyword;

public class KeywordConverter {

    public Keyword dtoToEntity(KeywordDto keywordDto) {
        Keyword keyword = new Keyword();

        keyword.setName(keywordDto.getName());

        return keyword;
    }

    public KeywordDto entityToDto(Keyword keyword) {
        KeywordDto keywordDto = new KeywordDto();
        JobConverter jobConverter = new JobConverter();

        keywordDto.setName(keyword.getName());

        return keywordDto;
    }

}