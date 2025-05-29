package com.jobservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "JOB")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String description;
    private String company;
    private String skills;
    private Integer salary;

    @Column(name = "is_remote")
    private boolean isRemote;
}
