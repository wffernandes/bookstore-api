package com.william.bookstore.config;

import com.william.bookstore.service.DBServise;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfig {

    private final DBServise dbServise;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String strategy;

    public DevConfig(DBServise dbServise) {
        this.dbServise = dbServise;
    }

    @Bean
    public Boolean instanciaBaseDeDados() {
        if(strategy.equals("create")) {
            this.dbServise.instanciaBaseDeDados();
        }
        return false;
    }
}
