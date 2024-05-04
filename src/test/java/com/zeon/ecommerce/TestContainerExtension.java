package com.zeon.ecommerce;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.springframework.test.annotation.DirtiesContext;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@DirtiesContext
public class TestContainerExtension implements BeforeAllCallback, AfterAllCallback {

    @Container
    private PostgreSQLContainer<?> postgres;

    @Override
    public void beforeAll(ExtensionContext context) {
        postgres = new PostgreSQLContainer<>("postgres:14.5").withUsername("postgres")
                .withPassword("pass").withExposedPorts(5432);
        postgres.start();

        System.setProperty("spring.datasource.url", postgres.getJdbcUrl());
        System.setProperty("spring.datasource.username", postgres.getUsername());
        System.setProperty("spring.datasource.password", postgres.getPassword());
    }

    @Override
    public void afterAll(ExtensionContext context) {
        // do nothing, Testcontainers handles container shutdown

    }

}
