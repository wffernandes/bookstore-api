package com.william.bookstore.config;

import com.william.bookstore.service.DBServise;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {

    private final DBServise dbServise;

    public TestConfig(DBServise dbServise) {
        this.dbServise = dbServise;
    }

    @Bean
    public int instaciaBaseDeDados() {
        return this.dbServise.instanciaBaseDeDados();
    }
}
