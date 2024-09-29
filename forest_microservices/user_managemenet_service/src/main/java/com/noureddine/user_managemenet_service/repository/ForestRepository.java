package com.noureddine.user_managemenet_service.repository;


import com.noureddine.commonlibrary.model.Forest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ForestRepository extends JpaRepository<Forest, Long> {


    Optional<Forest> findByName(String name);

}
