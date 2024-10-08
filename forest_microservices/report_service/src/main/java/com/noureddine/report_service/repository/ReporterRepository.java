package com.noureddine.report_service.repository;


import com.noureddine.commonlibrary.model.Reporter;
import com.noureddine.commonlibrary.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ReporterRepository extends JpaRepository<User, UUID> {

    Reporter findReporterById(UUID id);
}
