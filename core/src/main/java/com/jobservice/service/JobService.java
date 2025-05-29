package com.jobservice.service;

import com.job.messages.Job;
import com.jobservice.dto.JobDto;
import org.springframework.data.domain.Page;

public interface JobService {
    Page<JobDto> getAllJobs();

    Page<JobDto> getAllJobsBySkills(String skills);

    void save(Job jobDto);
}
