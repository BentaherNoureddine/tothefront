package com.noureddine.user_managemenet_service.service;


import com.noureddine.commonlibrary.model.Forest;
import com.noureddine.user_managemenet_service.repository.ForestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AppAdminService {

    private final ForestRepository forestRepository;



    //CREATE NEW FOREST
    public ResponseEntity<?> createForest(String name){

        Optional<Forest> forestOptional = forestRepository.findByName(name);

       if(forestOptional.isPresent()){
           return ResponseEntity.status(HttpStatus.CONFLICT).body("FOREST ALREADY EXISTS");
       }
       else {

           Forest forest = new Forest();
           forest.setName(name);
           forestRepository.save(forest);
           return new ResponseEntity<>(HttpStatus.CREATED);
       }
    }
}
