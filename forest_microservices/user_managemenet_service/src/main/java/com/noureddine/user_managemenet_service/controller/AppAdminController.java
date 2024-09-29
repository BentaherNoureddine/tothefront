package com.noureddine.user_managemenet_service.controller;





import com.noureddine.user_managemenet_service.service.AppAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.UUID;


@RestController
@RequestMapping("/management/admin/")
@RequiredArgsConstructor
public class AppAdminController {

    private final AppAdminService appAdminService;


    @PostMapping("/create/forest")
    public ResponseEntity<?> createForest(@RequestParam("name") String name) {

       return appAdminService.createForest(name);

    }


}
