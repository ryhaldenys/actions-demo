package com.jobservice.service.impl;

import com.job.messages.Job;
import com.jobservice.dto.JobDto;
import com.jobservice.mapper.EntityMapper;
import com.jobservice.repository.JobRepository;
import com.jobservice.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {
    private final JobRepository jobRepository;
    private final EntityMapper entityMapper;

    public Page<JobDto> getAllJobs() {
        return jobRepository.findAll(PageRequest.ofSize(Integer.MAX_VALUE)).map(entityMapper::toDto);
    }

    public Page<JobDto> getAllJobsBySkills(String skills) {
        return jobRepository.findBySkillsLike(skills, PageRequest.ofSize(Integer.MAX_VALUE)).map(entityMapper::toDto);
    }

    public void save(Job jobDto) {
        var jobEntity = entityMapper.toEntityFromMessage(jobDto);
        jobEntity.setId(null);
        jobRepository.save(jobEntity);
    }
}
