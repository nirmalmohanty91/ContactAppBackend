package com.cdk.customerdb.configuration;

import com.cdk.customerdb.domain.aware.AuditorAwareImpl;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@EntityScan(basePackages = {"com.cdk.customerdb.domain.entity"})
@EnableJpaRepositories(basePackages = {"com.cdk.customerdb.domain.repository"})
public class JpaConfiguration {

    @Bean
    public AuditorAware<String> auditorAware(){
        return new AuditorAwareImpl();
    }
}
