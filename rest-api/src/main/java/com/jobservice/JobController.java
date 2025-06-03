package com.jobservice;

import com.jobservice.producer.JobProducer;
import com.jobservice.rest_api.generated.api.JobApi;
import com.jobservice.rest_api.generated.model.JobDTO;
import com.jobservice.service.JobService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class JobController implements JobApi {
    private final JobProducer jobProducer;
    private final JobService jobService;
    private final JobMapper jobMapper;

    @Override
    public void createJob(JobDTO jobDTO) {
        jobProducer.produceJobMessage(jobMapper.toDto(jobDTO));
    }

    @Override
    public List<JobDTO> getAllJobs() {
        return jobService.getAllJobs().get().map(jobMapper::toDTO).toList();
    }

    @Override
    public List<JobDTO> searchJobs(String skills) {
        return jobService.getAllJobsBySkills(skills).get().map(jobMapper::toDTO).toList();
    }
}
