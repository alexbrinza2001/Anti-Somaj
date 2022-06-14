package com.project.backend.controller;

import com.project.backend.dto.KeywordDto;
import com.project.backend.service.KeywordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KeywordController {

    @Autowired
    KeywordService keywordService;

    @PostMapping("/keyword")
    public ResponseEntity<KeywordDto> addKeyword(@RequestBody KeywordDto keywordDto) {
        keywordService.addKeyword(keywordDto);

        return ResponseEntity.ok(keywordDto);
    }

    @GetMapping("/keywords")
    public ResponseEntity<List<KeywordDto>> getKeywords() {
        List<KeywordDto> keywordList = keywordService.getKeywords();

        return ResponseEntity.ok(keywordList);
    }

}
