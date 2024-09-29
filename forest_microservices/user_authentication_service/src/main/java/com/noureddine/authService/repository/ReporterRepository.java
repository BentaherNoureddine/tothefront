package com.noureddine.authService.repository;


import com.noureddine.commonlibrary.model.Reporter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;



@EnableJpaRepositories(basePackages = "com.noureddine.authService.repository")
@Repository
public interface ReporterRepository extends JpaRepository<Reporter, UUID> {


    Optional<Reporter> findByEmail(String email);
}
