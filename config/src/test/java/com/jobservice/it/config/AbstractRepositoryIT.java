package com.jobservice.it.config;

import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.BindMode;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
public abstract class AbstractRepositoryIT {
    private static final int DB_PORT = 5432;
    public static final String INIT_FILE = "docker-entrypoint-initdb.d/init.sql";
    public static final String DB_URL_FORMAT = "jdbc:postgresql://%s:%s/JOBS";

    @Container
    private static final GenericContainer<?> container = new GenericContainer<>("postgres")
            .withEnv("POSTGRES_USER", "root")
            .withEnv("POSTGRES_PASSWORD", "root")
            .withEnv("POSTGRES_DB", "JOBS")
            .withExposedPorts(DB_PORT)
            .withClasspathResourceMapping("test-compose/db/init.sql", INIT_FILE, BindMode.READ_ONLY)
            .waitingFor(Wait.forListeningPort());


    @DynamicPropertySource
    static void doProperties(DynamicPropertyRegistry registry) {
        container.start();
        registry.add("spring.datasource.url", ()-> String.format(DB_URL_FORMAT, container.getHost(), container.getMappedPort(DB_PORT)));
    }
}
