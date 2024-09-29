package com.noureddine.commonlibrary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EntityScan(basePackages = "com.noureddine.commonlibrary")
@EnableJpaAuditing
public class CommonLibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommonLibraryApplication.class, args);
    }

}
