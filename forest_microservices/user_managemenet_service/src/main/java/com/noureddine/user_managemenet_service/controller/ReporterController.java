package com.noureddine.user_managemenet_service.controller;


import com.noureddine.user_managemenet_service.dto.UpdateUserRequest;
import com.noureddine.user_managemenet_service.service.ReporterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("management/reporter")
public class ReporterController {

    private final ReporterService reporterService;


    //GET USER BY EMAIL API
    @GetMapping("/get/reporter")
    public ResponseEntity<?> getUserByEmail(@RequestParam(name = "email") String email) {


       if(reporterService.findReporterByEmail(email)!=null) {
           return new ResponseEntity<>(reporterService.findReporterByEmail(email), HttpStatus.OK);
       }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("USER NOT FOUND");
    }



    //UPDATE USER
    @PutMapping("/update/user/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") UUID id,
                                        @RequestBody UpdateUserRequest updateUserRequest) {

        return
            reporterService.updateUser(id,updateUserRequest);



    }

    @DeleteMapping("/delete/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") UUID id) {

       return
               reporterService.deleteUser(id);
    }




}
