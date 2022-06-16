package com.project.backend.controller;

import com.project.backend.dto.BugReportDto;
import com.project.backend.service.BugReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BugReportController {

    @Autowired
    BugReportService bugReportService;

    @PostMapping("/bugReport")
    public ResponseEntity<BugReportDto> addBugReport(@RequestBody BugReportDto bugReportDto) {
        bugReportService.addBugReport(bugReportDto);

        return ResponseEntity.ok(bugReportDto);
    }

    @GetMapping("/bugReports")
    public ResponseEntity<List<BugReportDto>> getBugReports() {
        List<BugReportDto> bugReportList = bugReportService.getBugReports();

        return ResponseEntity.ok(bugReportList);
    }

}
