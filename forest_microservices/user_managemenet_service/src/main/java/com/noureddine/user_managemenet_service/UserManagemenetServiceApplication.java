package com.noureddine.user_managemenet_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaAuditing
@EntityScan(basePackages = {"com.noureddine.commonlibrary","com.noureddine.user_managemenet_service.model"})
@EnableJpaRepositories(basePackages = "com.noureddine.user_managemenet_service.repository")
public class UserManagemenetServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserManagemenetServiceApplication.class, args);
    }

}
