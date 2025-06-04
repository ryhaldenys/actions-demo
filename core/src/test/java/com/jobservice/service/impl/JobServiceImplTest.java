package com.jobservice.service.impl;

import com.jobservice.dto.JobDto;
import com.jobservice.entity.Job;
import com.jobservice.mapper.EntityMapper;
import com.jobservice.repository.JobRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JobServiceImplTest {

    @Mock
    private JobRepository jobRepository;

    @Mock
    private EntityMapper entityMapper;

    @InjectMocks
    private JobServiceImpl jobService;

    @Test
    void testGetAllJobs() {
        JobDto jobDto = new JobDto();
        Page<JobDto> jobDtoPage = new PageImpl<>(Collections.singletonList(jobDto));
        when(jobRepository.findAll(any(PageRequest.class)))
                .thenReturn(new PageImpl<>(Collections.singletonList(new Job())));
        when(entityMapper.toDto(any())).thenReturn(jobDto);

        // Act
        Page<JobDto> result = jobService.getAllJobs();

        // Assert
        assertEquals(jobDtoPage.getContent().size(), result.getContent().size());
        verify(jobRepository, times(1)).findAll(any(PageRequest.class));
        verify(entityMapper, times(1)).toDto(any());
    }

    @Test
    void testGetAllJobsBySkills() {
        // Arrange
        String skills = "Java";
        JobDto jobDto = new JobDto();
        Page<JobDto> jobDtoPage = new PageImpl<>(Collections.singletonList(jobDto));
        when(jobRepository.findBySkillsLike(eq(skills), any(PageRequest.class)))
                .thenReturn(new PageImpl<>(Collections.singletonList(new Job())));
        when(entityMapper.toDto(any())).thenReturn(jobDto);

        // Act
        Page<JobDto> result = jobService.getAllJobsBySkills(skills);

        // Assert
        assertEquals(jobDtoPage.getContent().size(), result.getContent().size());
        verify(jobRepository, times(1)).findBySkillsLike(eq(skills), any(PageRequest.class));
        verify(entityMapper, times(1)).toDto(any());
    }

    @Test
    void testSave() {
        // Arrange
        com.job.messages.Job job = new com.job.messages.Job();
        when(entityMapper.toEntityFromMessage(any(com.job.messages.Job.class)))
                .thenReturn(new com.jobservice.entity.Job());

        // Act
        jobService.save(job);

        // Assert
        verify(entityMapper, times(1)).toEntityFromMessage(any(com.job.messages.Job.class));
        verify(jobRepository, times(1)).save(any(com.jobservice.entity.Job.class));
    }
}
