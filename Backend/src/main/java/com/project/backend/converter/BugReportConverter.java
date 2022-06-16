package com.project.backend.converter;

import com.project.backend.dto.BugReportDto;
import com.project.backend.entity.BugReport;

public class BugReportConverter {

    public BugReport dtoToEntity(BugReportDto bugReportDto) {
        BugReport bugReport = new BugReport();

        bugReport.setBug(bugReportDto.getBug());

        return bugReport;
    }

    public BugReportDto entityToDto(BugReport bugReport) {
        BugReportDto bugReportDto = new BugReportDto();

        bugReportDto.setBug(bugReport.getBug());

        return bugReportDto;
    }

}