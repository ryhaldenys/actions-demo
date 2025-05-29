package com.jobservice;

import com.jobservice.dto.JobDto;
import com.jobservice.rest_api.generated.model.JobDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface JobMapper {
        @Mapping(target = "remote", expression = "java(jobDTO.getIsRemote())")
        JobDto toDto(JobDTO jobDTO);

        @Mapping(target = "isRemote", expression = "java(jobDto.isRemote())")
        JobDTO toDTO(JobDto jobDto);
}
