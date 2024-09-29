package com.noureddine.report_service.repository;


import com.noureddine.commonlibrary.model.Forest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForestRepository extends JpaRepository<Forest, Long> {

    Forest findByName(String name);

    Forest findById(long id);
}
