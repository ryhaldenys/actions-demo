package com.jobservice.consumer;

import com.job.messages.Job;
import com.jobservice.service.JobService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Slf4j
@Component("jobs")
@RequiredArgsConstructor
public class JobsConsumer implements Consumer<Message<Job>> {
    private final JobService jobService;

    @Override
    public void accept(Message<Job> job) {
        log.info("JOB PROCESSING. Job was received with key: {}", job.getHeaders().get(KafkaHeaders.KEY));
        jobService.save(job.getPayload());
    }
}

