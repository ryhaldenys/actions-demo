package com.jobservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobDto {
    private UUID id;
    private String description;
    private String company;
    private String skills;
    private Integer salary;
    private boolean isRemote;
}
