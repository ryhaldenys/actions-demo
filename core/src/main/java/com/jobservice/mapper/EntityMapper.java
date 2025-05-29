package com.jobservice.mapper;

import com.jobservice.dto.JobDto;
import com.jobservice.entity.Job;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EntityMapper {
    JobDto toDto(Job job);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "company", expression = "java(jobMessage.getCompany().toString())")
    @Mapping(target = "skills", expression = "java(jobMessage.getSkills().toString())")
    @Mapping(target = "description", expression = "java(jobMessage.getDescription().toString())")
    @Mapping(target = "remote", expression = "java(jobMessage.getIsRemote())")
    Job toEntityFromMessage(com.job.messages.Job jobMessage);

    @Mapping(target = "id", expression = "java(job.getId().toString())")
    @Mapping(target = "isRemote", expression = "java(job.isRemote())")
    com.job.messages.Job toMessageFromDto(JobDto job);


}
