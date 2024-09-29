package com.noureddine.user_managemenet_service.repository;


import com.noureddine.commonlibrary.model.Reporter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource
public interface ReporterRepository extends JpaRepository<Reporter, UUID> {


    Reporter findByEmail(String email);
}
