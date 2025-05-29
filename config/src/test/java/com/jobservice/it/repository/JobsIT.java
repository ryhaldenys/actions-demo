package com.jobservice.it.repository;

import com.jobservice.entity.Job;
import com.jobservice.repository.JobRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.jdbc.Sql;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class JobsIT {
    @Autowired
    private JobRepository jobRepository;

    @Test
    @Sql(value = "classpath:sql-scripts/insert-job.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(value = "classpath:sql-scripts/clear-job-table.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void shouldGetBySkills() {
        var response = jobRepository.findBySkillsLike("skill", Pageable.ofSize(10));
        var job = new Job(
                UUID.fromString("3b1dc4ff-395a-44b1-a586-1582dfaf2e8a"),
                "job",
                "company",
                "skill",
                100,
                true
        );

        assertThat(response.getTotalElements()).isEqualTo(1);
        assertThat(response.getContent().get(0)).isEqualTo(job);
    }

}
