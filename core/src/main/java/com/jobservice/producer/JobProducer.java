package com.jobservice.producer;

import com.jobservice.dto.JobDto;
import com.jobservice.mapper.EntityMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class JobProducer {
    private final StreamBridge streamBridge;
    private final EntityMapper entityMapper;

    public void produceJobMessage(JobDto jobDto) {
        streamBridge.send("jobs-out-0", entityMapper.toMessageFromDto(jobDto));
    }
}
