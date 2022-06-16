package com.project.backend.service;

import com.project.backend.converter.BugReportConverter;
import com.project.backend.dto.BugReportDto;
import com.project.backend.entity.BugReport;
import com.project.backend.repo.JobRepo;
import com.project.backend.repo.BugReportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BugReportService {

    @Autowired
    BugReportRepo bugReportRepository;

    @Autowired
    JobRepo jobRepository;

    public void addBugReport(BugReportDto bugReportDto) {
        BugReportConverter bugReportConverter = new BugReportConverter();

        bugReportRepository.save(bugReportConverter.dtoToEntity(bugReportDto));
    }

    public List<BugReportDto> getBugReports() {
        BugReportConverter bugReportConverter = new BugReportConverter();


        List<BugReport> bugReportList = bugReportRepository.findAll();
        List<BugReportDto> bugReports = new ArrayList<BugReportDto>();

        for (BugReport bugReport : bugReportList) {
            BugReportDto bugReportDto = bugReportConverter.entityToDto(bugReport);

            bugReports.add(bugReportDto);
        }

        return bugReports;
    }

}