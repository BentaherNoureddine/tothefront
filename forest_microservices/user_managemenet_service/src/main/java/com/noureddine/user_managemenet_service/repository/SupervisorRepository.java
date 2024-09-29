package com.noureddine.user_managemenet_service.repository;

import com.noureddine.commonlibrary.model.Supervisor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.UUID;


@RepositoryRestResource
public interface SupervisorRepository extends JpaRepository<Supervisor, UUID> {
}
