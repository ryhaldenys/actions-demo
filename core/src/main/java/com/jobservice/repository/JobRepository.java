package com.jobservice.repository;

import com.jobservice.entity.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JobRepository extends JpaRepository<Job, UUID> {

    @Query("SELECT j FROM Job j WHERE j.skills LIKE CONCAT('%',:skills,'%')")
    Page<Job> findBySkillsLike(String skills, Pageable pageable);
}
